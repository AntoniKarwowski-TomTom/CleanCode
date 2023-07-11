package exercise.four.example.vehicle;

import exercise.four.example.Animal;

public class Carriage extends Vehicle {

  private final int sits;
  private final int busySits;

  public Carriage(Animal animal, int sits, int busySits) {
    super(animal);
    this.sits = sits;
    this.busySits = busySits;
  }


  @Override
  public boolean isAvailable() {
    return sits > busySits;
  }
}
