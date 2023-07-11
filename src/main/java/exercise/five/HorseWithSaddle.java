package exercise.five;

public class HorseWithSaddle {
  private boolean isCarryingSomeone;
  private String horseName;
  private String CountryOfOrigin;

  public HorseWithSaddle(boolean isCarryingSomeone, String horseName, String countryOfOrigin) {
    this.isCarryingSomeone = isCarryingSomeone;
    this.horseName = horseName;
    CountryOfOrigin = countryOfOrigin;
  }

  public void info() {
    System.out.println(isCarryingSomeone + " busy, name: " + horseName + " from " + CountryOfOrigin);
  }
}
