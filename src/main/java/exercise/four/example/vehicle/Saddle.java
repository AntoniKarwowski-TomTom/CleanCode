package exercise.four.example.vehicle;

import exercise.four.example.Animal;

public class Saddle extends Vehicle {

  private final boolean freeBackSit;
  private final boolean freeFrontSit;

  public Saddle(Animal animal, boolean freeBackSit, boolean freeFrontSit) {
    super(animal);
    this.freeBackSit = freeBackSit;
    this.freeFrontSit = freeFrontSit;
  }

  @Override
  public boolean isAvailable() {
    return freeBackSit || freeFrontSit;
  }
}
