package exercise.two.example;

import java.util.List;

public class Animal {

  private Animal mother;
  private String name;
  private List<Animal> children;

  public void assignChild(Animal child) throws IncestException {
    if (child != mother) {
      children.add(child);
    } else {
      throw new IncestException("Cannot assign mother as a child");
    }
  }

  public Animal getChild(String name) throws IllegalArgumentException {
    try {
      validateName(name);
      return children.stream().filter(child -> child.name.equals(name)).findFirst()
          // or return optional
          // depends on business logic
          .orElseThrow();
    } catch (Exception e) {
      throw new IllegalArgumentException(String.format("couldn't find child: %s", name), e);
      // return Optional.empty();
      // depends on business logic:
    }
  }

  private void validateName(String name) throws IllegalAnimalNameException {
    if (name.isEmpty()) {
      throw new IllegalAnimalNameException("name is empty");
    } else if (name.length() < 2) {
      throw new IllegalAnimalNameException("name is too short");
    } else if (name.length() > 20) {
      throw new IllegalAnimalNameException("name is too long");
    }
  }
}
