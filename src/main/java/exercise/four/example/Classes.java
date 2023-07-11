package exercise.four.example;

import exercise.four.example.vehicle.Carriage;
import exercise.four.example.vehicle.Saddle;
import exercise.four.example.vehicle.Sleigh;
import java.util.List;

public class Classes {

  public static void main(String[] args) {
    Animal horse = new Animal("horse", "Charlie", "Spain");
    Animal dog = new Animal("dog", "Alex", "Germany");
    List.of(
        new Carriage(horse, 3, 2),
        new Saddle(dog, false, false),
        new Sleigh(horse, true)
    ).forEach(vehicle -> System.out.println(vehicle.describe()));
  }
}