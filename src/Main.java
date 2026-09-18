import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static StudentManager studentManager = new StudentManager();
    private static CourseManager courseManager = new CourseManager();
    private static RegistrationManager registrationManager =
            new RegistrationManager(studentManager, courseManager);

    public static void main(String[] args) {

        FileManager.initializeFiles();

        loadData();

        System.out.println("=========================================");
        System.out.println("       COURSE REGISTRATION SYSTEM");
        System.out.println("=========================================");

        boolean running = true;

        while (running) {

            displayMainMenu();

            int choice = readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    studentManagement();
                    break;

                case 2:
                    courseManagement();
                    break;

                case 3:
                    registrationManagement();
                    break;

                case 4:
                    registrationManager.displayAllRegistrations();
                    break;

                case 5:
                    saveData();
                    System.out.println(
                            "\nThank you for using Course Registration System."
                    );
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }

    // ================= MAIN MENU =================

    private static void displayMainMenu() {

        System.out.println("\n=========================================");
        System.out.println("              MAIN MENU");
        System.out.println("=========================================");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Course Registration");
        System.out.println("4. Registration Report");
        System.out.println("5. Exit");
        System.out.println("=========================================");
    }

    // ================= STUDENT MANAGEMENT =================

    private static void studentManagement() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== STUDENT MANAGEMENT ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Back");

            int choice = readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    studentManager.displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    removeStudent();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        String id = readNonEmpty("Enter Student ID: ");

        if (studentManager.findStudent(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        String name = readNonEmpty("Enter Student Name: ");

        String email;

        while (true) {

            email = readNonEmpty("Enter Email: ");

            if (InputValidator.isValidEmail(email)) {
                break;
            }

            System.out.println(
                    "Invalid email. Please enter a valid email."
            );
        }

        String program = readNonEmpty("Enter Program: ");

        Student student =
                new Student(id, name, email, program);

        if (studentManager.addStudent(student)) {

            FileManager.saveStudents(
                    studentManager.getStudents()
            );

            System.out.println(
                    "Student added successfully."
            );

        } else {

            System.out.println(
                    "Unable to add student."
            );
        }
    }

    private static void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        String id = readNonEmpty("Enter Student ID: ");

        Student student = studentManager.findStudent(id);

        if (student != null) {
            System.out.println("\nStudent Found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent() {

        System.out.println("\n========== REMOVE STUDENT ==========");

        String id = readNonEmpty("Enter Student ID: ");

        if (studentManager.removeStudent(id)) {

            FileManager.saveStudents(
                    studentManager.getStudents()
            );

            System.out.println(
                    "Student removed successfully."
            );

        } else {

            System.out.println(
                    "Student not found."
            );
        }
    }

    // ================= COURSE MANAGEMENT =================

    private static void courseManagement() {

        boolean back = false;

        while (!back) {

            System.out.println("\n========== COURSE MANAGEMENT ==========");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Remove Course");
            System.out.println("5. Back");

            int choice = readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    addCourse();
                    break;

                case 2:
                    courseManager.displayCourses();
                    break;

                case 3:
                    searchCourse();
                    break;

                case 4:
                    removeCourse();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addCourse() {

        System.out.println("\n========== ADD COURSE ==========");

        String id = readNonEmpty("Enter Course ID: ");

        if (courseManager.findCourse(id) != null) {
            System.out.println("Course ID already exists.");
            return;
        }

        String name =
                readNonEmpty("Enter Course Name: ");

        int credits;

        while (true) {

            credits = readInteger("Enter Credits: ");

            if (credits > 0 && credits <= 10) {
                break;
            }

            System.out.println(
                    "Credits must be between 1 and 10."
            );
        }

        int capacity;

        while (true) {

            capacity =
                    readInteger("Enter Course Capacity: ");

            if (capacity > 0) {
                break;
            }

            System.out.println(
                    "Capacity must be greater than 0."
            );
        }

        Course course =
                new Course(id, name, credits, capacity);

        if (courseManager.addCourse(course)) {

            FileManager.saveCourses(
                    courseManager.getCourses()
            );

            System.out.println(
                    "Course added successfully."
            );

        } else {

            System.out.println(
                    "Unable to add course."
            );
        }
    }

    private static void searchCourse() {

        System.out.println("\n========== SEARCH COURSE ==========");

        String id = readNonEmpty("Enter Course ID: ");

        Course course = courseManager.findCourse(id);

        if (course != null) {

            System.out.println("\nCourse Found:");
            System.out.println(course);

        } else {

            System.out.println("Course not found.");
        }
    }

    private static void removeCourse() {

        System.out.println("\n========== REMOVE COURSE ==========");

        String id = readNonEmpty("Enter Course ID: ");

        if (courseManager.removeCourse(id)) {

            FileManager.saveCourses(
                    courseManager.getCourses()
            );

            System.out.println(
                    "Course removed successfully."
            );

        } else {

            System.out.println(
                    "Course not found."
            );
        }
    }

    // ================= REGISTRATION MANAGEMENT =================

    private static void registrationManagement() {

        boolean back = false;

        while (!back) {

            System.out.println(
                    "\n======= REGISTRATION MANAGEMENT ======="
            );

            System.out.println("1. Register Student for Course");
            System.out.println("2. Drop Course");
            System.out.println("3. View Student Courses");
            System.out.println("4. Check Course Availability");
            System.out.println("5. Back");

            int choice =
                    readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    dropCourse();
                    break;

                case 3:
                    viewStudentCourses();
                    break;

                case 4:
                    checkCourseAvailability();
                    break;

                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void registerStudent() {

        System.out.println(
                "\n========== COURSE REGISTRATION =========="
        );

        String studentId =
                readNonEmpty("Enter Student ID: ");

        String courseId =
                readNonEmpty("Enter Course ID: ");

        String result =
                registrationManager.registerStudent(
                        studentId,
                        courseId
                );

        if (result.equals("Student registered successfully.")) {

            FileManager.saveRegistrations(
                    registrationManager.getRegistrations()
            );

            FileManager.saveCourses(
                    courseManager.getCourses()
            );
        }

        System.out.println(result);
    }

    private static void dropCourse() {

        System.out.println(
                "\n========== DROP COURSE =========="
        );

        String studentId =
                readNonEmpty("Enter Student ID: ");

        String courseId =
                readNonEmpty("Enter Course ID: ");

        String result =
                registrationManager.dropCourse(
                        studentId,
                        courseId
                );

        if (result.equals("Course dropped successfully.")) {

            FileManager.saveRegistrations(
                    registrationManager.getRegistrations()
            );

            FileManager.saveCourses(
                    courseManager.getCourses()
            );
        }

        System.out.println(result);
    }

    private static void viewStudentCourses() {

        System.out.println(
                "\n========== STUDENT COURSES =========="
        );

        String studentId =
                readNonEmpty("Enter Student ID: ");

        registrationManager.displayStudentCourses(
                studentId
        );
    }

    private static void checkCourseAvailability() {

        System.out.println(
                "\n========== COURSE AVAILABILITY =========="
        );

        String courseId =
                readNonEmpty("Enter Course ID: ");

        registrationManager.displayCourseAvailability(
                courseId
        );
    }

    // ================= DATA MANAGEMENT =================

    private static void loadData() {

        for (Student student :
                FileManager.loadStudents()) {

            studentManager.addStudent(student);
        }

        for (Course course :
                FileManager.loadCourses()) {

            courseManager.addCourse(course);
        }

        for (Registration registration :
                FileManager.loadRegistrations()) {

            Student student =
                    studentManager.findStudent(
                            registration.getStudentId()
                    );

            Course course =
                    courseManager.findCourse(
                            registration.getCourseId()
                    );

            if (student != null && course != null) {

                if (!course.isFull()) {

                    course.enrollStudent();

                    registrationManager.getRegistrations()
                            .add(registration);
                }
            }
        }

        // Add sample data if files are empty
        if (studentManager.getStudents().isEmpty()) {
            studentManager.addSampleStudents();
            FileManager.saveStudents(
                    studentManager.getStudents()
            );
        }

        if (courseManager.getCourses().isEmpty()) {
            courseManager.addSampleCourses();
            FileManager.saveCourses(
                    courseManager.getCourses()
            );
        }
    }

    private static void saveData() {

        FileManager.saveStudents(
                studentManager.getStudents()
        );

        FileManager.saveCourses(
                courseManager.getCourses()
        );

        FileManager.saveRegistrations(
                registrationManager.getRegistrations()
        );
    }

    // ================= INPUT METHODS =================

    private static String readNonEmpty(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!InputValidator.isEmpty(input)) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }

    private static int readInteger(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}