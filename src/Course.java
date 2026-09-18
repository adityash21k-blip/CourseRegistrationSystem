public class Course {
    private String courseId;
    private String courseName;
    private int credits;
    private int capacity;
    private int enrolledStudents;

    public Course(String courseId, String courseName, int credits, int capacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }

    public boolean enrollStudent() {
        if (isFull()) {
            return false;
        }

        enrolledStudents++;
        return true;
    }

    public void removeStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public int getAvailableSeats() {
        return capacity - enrolledStudents;
    }

    @Override
    public String toString() {
        return "ID: " + courseId +
               " | Course: " + courseName +
               " | Credits: " + credits +
               " | Capacity: " + capacity +
               " | Enrolled: " + enrolledStudents +
               " | Available: " + getAvailableSeats();
    }

    public String toFileString() {
        return courseId + "," + courseName + "," + credits + "," + capacity;
    }
}