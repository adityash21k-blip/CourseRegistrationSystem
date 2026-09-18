import java.util.ArrayList;

public class RegistrationManager {

    private ArrayList<Registration> registrations;
    private StudentManager studentManager;
    private CourseManager courseManager;

    public RegistrationManager(StudentManager studentManager,
                               CourseManager courseManager) {
        this.registrations = new ArrayList<>();
        this.studentManager = studentManager;
        this.courseManager = courseManager;
    }

    // Register a student for a course
    public String registerStudent(String studentId, String courseId) {

        Student student = studentManager.findStudent(studentId);

        if (student == null) {
            return "Student not found.";
        }

        Course course = courseManager.findCourse(courseId);

        if (course == null) {
            return "Course not found.";
        }

        if (isAlreadyRegistered(studentId, courseId)) {
            return "Student is already registered for this course.";
        }

        if (course.isFull()) {
            return "Registration failed. The course is full.";
        }

        course.enrollStudent();

        Registration registration =
                new Registration(studentId, courseId);

        registrations.add(registration);

        return "Student registered successfully.";
    }

    // Check whether a student is already registered
    public boolean isAlreadyRegistered(String studentId, String courseId) {

        for (Registration registration : registrations) {

            if (registration.getStudentId().equalsIgnoreCase(studentId)
                    && registration.getCourseId().equalsIgnoreCase(courseId)) {

                return true;
            }
        }

        return false;
    }

    // Drop a course
    public String dropCourse(String studentId, String courseId) {

        Registration registrationToRemove = null;

        for (Registration registration : registrations) {

            if (registration.getStudentId().equalsIgnoreCase(studentId)
                    && registration.getCourseId().equalsIgnoreCase(courseId)) {

                registrationToRemove = registration;
                break;
            }
        }

        if (registrationToRemove == null) {
            return "Registration not found.";
        }

        Course course = courseManager.findCourse(courseId);

        if (course != null) {
            course.removeStudent();
        }

        registrations.remove(registrationToRemove);

        return "Course dropped successfully.";
    }

    // Display all courses registered by a student
    public void displayStudentCourses(String studentId) {

        Student student = studentManager.findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        boolean found = false;

        System.out.println("\n========== REGISTERED COURSES ==========");
        System.out.println("Student: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());

        for (Registration registration : registrations) {

            if (registration.getStudentId().equalsIgnoreCase(studentId)) {

                Course course =
                        courseManager.findCourse(registration.getCourseId());

                if (course != null) {
                    System.out.println(
                            course.getCourseId()
                            + " | "
                            + course.getCourseName()
                            + " | Credits: "
                            + course.getCredits()
                    );

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No courses registered.");
        }
    }

    // Display course availability
    public void displayCourseAvailability(String courseId) {

        Course course = courseManager.findCourse(courseId);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\n========== COURSE AVAILABILITY ==========");
        System.out.println("Course ID: " + course.getCourseId());
        System.out.println("Course Name: " + course.getCourseName());
        System.out.println("Total Capacity: " + course.getCapacity());
        System.out.println("Enrolled Students: "
                + course.getEnrolledStudents());
        System.out.println("Available Seats: "
                + course.getAvailableSeats());

        if (course.isFull()) {
            System.out.println("Status: COURSE FULL");
        } else {
            System.out.println("Status: SEATS AVAILABLE");
        }
    }

    // Display all registrations
    public void displayAllRegistrations() {

        if (registrations.isEmpty()) {
            System.out.println("No registrations found.");
            return;
        }

        System.out.println("\n========== ALL REGISTRATIONS ==========");

        for (Registration registration : registrations) {

            Student student =
                    studentManager.findStudent(
                            registration.getStudentId());

            Course course =
                    courseManager.findCourse(
                            registration.getCourseId());

            if (student != null && course != null) {

                System.out.println(
                        "Student: " + student.getName()
                        + " (" + student.getStudentId() + ")"
                        + " | Course: " + course.getCourseName()
                        + " (" + course.getCourseId() + ")"
                );
            }
        }
    }

    // Get all registrations
    public ArrayList<Registration> getRegistrations() {
        return registrations;
    }
}
