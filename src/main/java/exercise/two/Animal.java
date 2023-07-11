package exercise.two;

import java.util.List;

public class Animal {

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
                for(Animal a: children) {
                   if(a.name == n) {
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
