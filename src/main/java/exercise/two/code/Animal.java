package exercise.two.code;

import java.util.List;

public class Animal {

  /*
   * refactor this code, focus mainly on exception handling, You can consider different
   * use cases:
   * 1) throw exception (f.e. useful to map them to HTTP response codes in REST Service)
   * 2) handle unusual cases with Optionals and return Empty f.e.  if nothing found
   */

  private Animal mother;
  private short yearOfBirth;
  private String name;
  private int weight;
  private List<Animal> children;

  public void child(Animal a) {
    try {
      if (a == mother) {
        throw new IllegalArgumentException("Error");
      } else {
        children.add(a);
      }
    } catch (Exception e) {
      System.out.println("Error");
    }
  }

  public Animal getChild(String n) {
    Animal d = null;
    try {
      if (n.isEmpty()) {
        throw new NullPointerException("Super error 1");
      } else if (n.length() < 2) {
        throw new IllegalArgumentException("Super error 2");
      } else if (n.length() > 20) {
        throw new IllegalArgumentException("Super error 3");
      } else {
        for (Animal a : children) {
          if (a.name == n) {
            d = children.get(children.indexOf(a));
          }
        }
      }
    } catch (Throwable e) {
      //Wrong name
    }
    return d;
  }

}
