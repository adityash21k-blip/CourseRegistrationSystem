import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a new student
    public boolean addStudent(Student student) {
        if (findStudent(student.getStudentId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search student by ID
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }

        return null;
    }

    // Remove student by ID
    public boolean removeStudent(String studentId) {
        Student student = findStudent(studentId);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    // Get all students
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Add sample students
    public void addSampleStudents() {
        addStudent(new Student(
                "S101",
                "Aditya Sharma",
                "aditya@example.com",
                "B.Tech CSE"
        ));

        addStudent(new Student(
                "S102",
                "Rahul Verma",
                "rahul@example.com",
                "B.Tech CSE"
        ));

        addStudent(new Student(
                "S103",
                "Priya Singh",
                "priya@example.com",
                "B.Tech AIML"
        ));
    }
}