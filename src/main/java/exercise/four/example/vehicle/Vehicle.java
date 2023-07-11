package exercise.four.example.vehicle;

import exercise.four.example.Animal;

public abstract class Vehicle {

  protected final Animal animal;

  protected Vehicle(Animal animal) {
    this.animal = animal;
  }

  public abstract boolean isAvailable();

  public String describe() {
    return new StringBuilder()
        .append("=============================")
        .append(System.lineSeparator())
        .append(
            String.format("vehicle %s with animal: %s named %s from %s",
                this.getClass().getSimpleName(),
                animal.type(), animal.name(), animal.country()))
        .append(System.lineSeparator())
        .append(isAvailable() ? "with free sits !!!" : "without any free sits !!!")
        .append(System.lineSeparator())
        .toString();
  }
}
