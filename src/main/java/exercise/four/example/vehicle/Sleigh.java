package exercise.four.example.vehicle;

import exercise.four.example.Animal;

public class Sleigh extends Vehicle {

  private final boolean isBusy;

  public Sleigh(Animal animal, boolean isBusy) {
    super(animal);
    this.isBusy = isBusy;
  }

  @Override
  public boolean isAvailable() {
    return !isBusy;
  }
}
