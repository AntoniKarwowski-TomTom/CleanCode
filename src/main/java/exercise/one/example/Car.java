package exercise.one.example;

import static exercise.one.example.CarRegulations.ENGINE_CAPACITY_CLASS_THRESHOLD;
import static exercise.one.example.CarRegulations.FAST_CAR_CLASS;
import static exercise.one.example.CarRegulations.MAX_EURO_ENGINE_CAPACITY;
import static exercise.one.example.CarRegulations.MIN_EURO_YEAR_OF_PRODUCTION;
import static exercise.one.example.CarRegulations.SLOW_CAR_CLASS;

public class Car {

  private int engineCapacity;
  private short yearOfProduction;

  public boolean isEuroFive() {
    return engineCapacity < MAX_EURO_ENGINE_CAPACITY
        && yearOfProduction > MIN_EURO_YEAR_OF_PRODUCTION;
  }

  public String speedClassification() {
    if (engineCapacity < ENGINE_CAPACITY_CLASS_THRESHOLD) {
      return SLOW_CAR_CLASS;
    } else {
      return FAST_CAR_CLASS;
    }
  }
}
