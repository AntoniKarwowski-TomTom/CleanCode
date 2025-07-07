package exercise.five.code;

import exercise.five.common.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * Ahh, so many foreach loops, maybe there is another way to approach that?
 */
public class StudentProcessor {

    private final List<Student> students;

    public StudentProcessor(List<Student> students) {
        this.students = students;
    }

    public List<Student> getPassingStudents() {
        List<Student> passingStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.score() >= 60) {
                passingStudents.add(student);
            }
        }
        return passingStudents;
    }

    public List<String> getNamesOfPassingStudents() {
        List<String> names = new ArrayList<>();
        for (Student student : getPassingStudents()) {
            names.add(student.name());
        }
        return names;
    }

    public double averageScoreOfPassingStudents() {
        double sum = 0;
        int count = 0;
        for (Student student : getPassingStudents()) {
            sum += student.score();
            count++;
        }
        return count > 0 ? sum / count : 0;
    }

    public List<Student> getStudentsWithNamesStartingWith(char letter) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.name().startsWith(String.valueOf(letter))) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
    public Student getStudentWithHighestScore() {
        if (students.isEmpty()) {
            return null;
        }

        Student highestScoringStudent = students.get(0);
        for (Student student : students) {
            if (student.score() > highestScoringStudent.score()) {
                highestScoringStudent = student;
            }
        }
        return highestScoringStudent;
    }

}