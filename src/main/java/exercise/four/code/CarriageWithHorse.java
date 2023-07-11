package exercise.four.code;

public class CarriageWithHorse {

  private int sits;
  private int busySits;
  private String placeHorseComesFrom;
  private String name;

  public CarriageWithHorse(int sits, int busySits, String placeHorseComesFrom, String name) {
    this.sits = sits;
    this.busySits = busySits;
    this.placeHorseComesFrom = placeHorseComesFrom;
    this.name = name;
  }

  public void status() {
    System.out.println("free: " + (sits - busySits > 0 ? "true" : "false"));
    System.out.println("name: " + name);
    System.out.println("horse is from: " + placeHorseComesFrom);
  }
}

