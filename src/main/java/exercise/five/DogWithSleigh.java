package exercise.five;

public class DogWithSleigh {
  private boolean emptyFrontSit;
  private boolean emptyBackSit;

  private String dogName;
  private String country;

  private DogWithSleigh(boolean emptyFrontSit, boolean emptyBackSit, String dogName,
      String country) {
    this.emptyFrontSit = emptyFrontSit;
    this.emptyBackSit = emptyBackSit;
    this.dogName = dogName;
    this.country = country;
  }

  public static DogWithSleigh build(boolean emptyFrontSit, boolean emptyBackSit, String dogName,
      String country) {
    return new DogWithSleigh(emptyFrontSit, emptyBackSit, dogName, country);
  }

  public boolean isEmpty() {
    return emptyBackSit && emptyFrontSit;
  }

  public String describe() {
    return String.format("Sleigh with a dog [%s] at this moment it's [%s]",
        dogName,
        isEmpty()? "empty": "occupied"
    );
  }
}
