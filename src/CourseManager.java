import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    // Add a new course
    public boolean addCourse(Course course) {
        if (findCourse(course.getCourseId()) != null) {
            return false;
        }

        courses.add(course);
        return true;
    }

    // Display all courses
    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("\n========== ALL COURSES ==========");

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Search course by ID
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(courseId)) {
                return course;
            }
        }

        return null;
    }

    // Remove course
    public boolean removeCourse(String courseId) {
        Course course = findCourse(courseId);

        if (course == null) {
            return false;
        }

        courses.remove(course);
        return true;
    }

    // Get all courses
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Add sample courses
    public void addSampleCourses() {
        addCourse(new Course(
                "CS101",
                "Java Programming",
                4,
                30
        ));

        addCourse(new Course(
                "CS102",
                "Data Structures",
                4,
                40
        ));

        addCourse(new Course(
                "CS103",
                "Database Management",
                3,
                35
        ));
    }
}
