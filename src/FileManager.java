import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String DATA_FOLDER = "data";
    private static final String STUDENT_FILE = DATA_FOLDER + "/students.txt";
    private static final String COURSE_FILE = DATA_FOLDER + "/courses.txt";
    private static final String REGISTRATION_FILE =
            DATA_FOLDER + "/registrations.txt";

    // Create data folder and files if they do not exist
    public static void initializeFiles() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdir();
        }

        createFileIfNotExists(STUDENT_FILE);
        createFileIfNotExists(COURSE_FILE);
        createFileIfNotExists(REGISTRATION_FILE);
    }

    private static void createFileIfNotExists(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {

            try {
                file.createNewFile();

            } catch (IOException e) {
                System.out.println(
                        "Error creating file: " + fileName
                );
            }
        }
    }

    // Save students to file
    public static void saveStudents(ArrayList<Student> students) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(STUDENT_FILE))) {

            for (Student student : students) {
                writer.println(student.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }

    // Load students from file
    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(STUDENT_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    students.add(new Student(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading student data.");
        }

        return students;
    }

    // Save courses to file
    public static void saveCourses(ArrayList<Course> courses) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(COURSE_FILE))) {

            for (Course course : courses) {
                writer.println(course.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving course data.");
        }
    }

    // Load courses from file
    public static ArrayList<Course> loadCourses() {

        ArrayList<Course> courses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(COURSE_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    try {

                        int credits = Integer.parseInt(data[2]);
                        int capacity = Integer.parseInt(data[3]);

                        courses.add(new Course(
                                data[0],
                                data[1],
                                credits,
                                capacity
                        ));

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid course data found."
                        );
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading course data.");
        }

        return courses;
    }

    // Save registrations to file
    public static void saveRegistrations(
            ArrayList<Registration> registrations) {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter(REGISTRATION_FILE))) {

            for (Registration registration : registrations) {
                writer.println(registration.toFileString());
            }

        } catch (IOException e) {
            System.out.println("Error saving registration data.");
        }
    }

    // Load registrations from file
    public static ArrayList<Registration> loadRegistrations() {

        ArrayList<Registration> registrations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(REGISTRATION_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 2) {

                    registrations.add(new Registration(
                            data[0],
                            data[1]
                    ));
                }
            }

        } catch (IOException e) {
            System.out.println(
                    "Error loading registration data."
            );
        }

        return registrations;
    }
}
