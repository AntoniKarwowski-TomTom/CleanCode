package exercise.five;

import java.util.List;

public class Classes {
  public static void main(String[] args) {
    // todo refactor those classes (+ possibly interfaces) using OOP principles
    new CarriageWithHorse(3, 2, "Spain", "SomeHorseName").status();
    new HorseWithSaddle(true, "DifferentHorseName", "Germany").info();
    System.out.println(DogWithSleigh.build(true, false, "Charlie", "England").describe());
  }
}