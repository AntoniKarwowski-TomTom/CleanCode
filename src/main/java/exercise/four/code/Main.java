package exercise.four.code;

public class Main {

  /*
   refactor those classes (+ possibly add some inheritance / composition) using OOP principles
   */

  public static void main(String[] args) {
    new CarriageWithHorse(3, 2, "Spain", "SomeHorseName").status();
    new HorseWithSaddle(true, "DifferentHorseName", "Germany").info();
    System.out.println(DogWithSleigh.build(true, false, "Charlie", "England").describe());
  }
}