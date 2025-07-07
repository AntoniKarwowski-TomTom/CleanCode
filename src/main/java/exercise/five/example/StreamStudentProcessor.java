package exercise.five.example;

import exercise.five.common.Student;

import java.util.List;

public class StreamStudentProcessor {

    private final List<Student> students;
    private final int passingCriteria;

    public StreamStudentProcessor(List<Student> students, int passingCriteria) {
        this.students = students;
        this.passingCriteria = passingCriteria;
    }

    public List<Student> getPassingStudents() {
        return students.stream()
                .filter(student -> student.score() >= passingCriteria)
                .toList();
    }

    public List<String> getNamesOfPassingStudents() {
        return getPassingStudents()
                .stream()
                .map(Student::name)
                .toList(); // można też collect(Collectors.toList()), ale jaka jest róźnica? ;)
    }

    public double averageScoreOfPassingStudents() {
        return getPassingStudents()
                .stream()
                .mapToDouble(Student::score)
                .average()
                .orElse(0);
    }

    public List<Student> getStudentsWithNamesStartingWith(char letter) {
        return students.stream()
                .filter(student -> student.name().startsWith(String.valueOf(letter)))
                .toList();
    }

    public List<Student> getStudentWithHighestScore() {
        int highestScore = students.stream()
                .mapToInt(Student::score)
                .max()
                .orElse(0);

        return students.stream()
                .filter(student -> student.score() == highestScore)
                .toList();
    }
}
