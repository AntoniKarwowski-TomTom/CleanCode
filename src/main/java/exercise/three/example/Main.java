package exercise.three.example;

import exercise.three.code.model.DynamicLocation;
import exercise.three.code.model.EppPoi;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static Optional<EppPoi> getMatchedPoiItem(DynamicLocation location, List<EppPoi> pois) {
    return pois
        .stream()
        .filter(poi -> poi.getEvseIds().containsAll(location.getEvseIds()))
        .max(Comparator.comparing(Main::extractProcessingTime));
  }

  private static Instant extractProcessingTime(EppPoi poi) {
    return Instant.parse(correctTimezone(poi.getLastProcessingTime()));
  }

  private static String correctTimezone(String time) {
    return time.endsWith("Z") ? time : time + "Z";
  }
}
