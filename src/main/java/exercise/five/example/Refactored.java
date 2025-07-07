package exercise.five.example;

import exercise.five.common.InMemoryStudentRepository;
import exercise.five.common.Student;

import java.util.List;

public class Refactored {
    public static void main(String[] args) {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        List<Student> students = repository.getAllStudents();

        int passingCriteria = 60;
        StreamStudentProcessor processor = new StreamStudentProcessor(students, passingCriteria);
        // Get passing students
        List<Student> passingStudents = processor.getPassingStudents();
        System.out.println("Passing Students: " + passingStudents.size());

        // Get names of passing students
        List<String> passingNames = processor.getNamesOfPassingStudents();
        System.out.println("Names of Passing Students: " + passingNames);

        // Calculate average score of passing students
        double averageScore = processor.averageScoreOfPassingStudents();
        System.out.println("Average Score of Passing Students: " + averageScore);

        // Get students with names starting with 'A'
        List<Student> studentsWithA = processor.getStudentsWithNamesStartingWith('A');
        System.out.println("Students with names starting with 'A': " + studentsWithA.size());

        List<Student> studentsWithHighestScore = processor.getStudentWithHighestScore();
        System.out.println("Students with highest score: " + studentsWithHighestScore);
    }
}