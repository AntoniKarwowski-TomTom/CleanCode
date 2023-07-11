package exercise.three.code;

import exercise.three.code.model.DynamicLocation;
import exercise.three.code.model.EppPoi;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  /*
   * feel free to reorganize this code, it also contains few bugs, which can be fixed :)
   *
   * DynamicLocation is the representation of EV ChargingStation status update (i.e Available, Charging, OutOfService)
   * EppPoi is a representation of physical EV ChargingStation
   * We have a list of Pois as we have diffrent occurences of the seme POI in different points in time
   * We need to match DynamicLocation to latest EV POI to process it somewhere else
   * Match is based on POI id and EVSE id (Electric Vehicle Supply Equiment)
   * Pois in this method context are already matched by POI id
   */
  public static EppPoi getMatchedPoiItem(DynamicLocation dynamicLocation,
      List<EppPoi> poiItemsReturnedFromDB) {
    if (poiItemsReturnedFromDB.size() == 1) {
      return poiItemsReturnedFromDB.get(0);
    }
    List<EppPoi> matchedPois = new ArrayList<>();
    for (EppPoi poiItem : poiItemsReturnedFromDB) {
      Set<String> evseIdsFromPoiItem = poiItem.getEvseIds();
      Set<String> evseIdsFromDynamicData = dynamicLocation.getEvseIds();
      if (evseIdsFromPoiItem.containsAll(evseIdsFromDynamicData)) {
        matchedPois.add(poiItem);
      }
    }
    int numberOfMatchedPois = matchedPois.size();
    if (numberOfMatchedPois == 0) {
      log.warn(
          "There's an Evse that's not in static database. ID of the dynamic location is "
              + dynamicLocation.getPoiId());
      return null;
    } else if (numberOfMatchedPois == 1) {
      return matchedPois.get(0);
    } else {
      log.info("Multiple POI items matched, getting the latest updated one...");
      Instant latestTime =
          Instant.parse(
              addMissingTimeZoneAsUTC(poiItemsReturnedFromDB.get(0).getLastProcessingTime()));
      EppPoi latestPoi = poiItemsReturnedFromDB.get(0);
      for (EppPoi poi : poiItemsReturnedFromDB.subList(1, poiItemsReturnedFromDB.size())) {
        Instant current = Instant.parse(addMissingTimeZoneAsUTC(poi.getLastProcessingTime()));
        if (current.isAfter(latestTime)) {
          latestTime = current;
          latestPoi = poi;
        }
      }
      return latestPoi;
    }
  }

  private static String addMissingTimeZoneAsUTC(String time) {
    if (!"Z".equals(time.substring(time.length() - 1))) {
      time = time + "Z";
    }
    return time;
  }
}
