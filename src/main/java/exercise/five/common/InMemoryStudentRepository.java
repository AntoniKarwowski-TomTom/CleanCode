package exercise.five.common;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentRepository {
    private final List<Student> students = new ArrayList<>();

    public InMemoryStudentRepository() {
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 55));
        students.add(new Student("Charlie", 75));
        students.add(new Student("Diana", 90));
        students.add(new Student("Eve", 45));
        students.add(new Student("Frank", 65));
        students.add(new Student("George", 50));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
