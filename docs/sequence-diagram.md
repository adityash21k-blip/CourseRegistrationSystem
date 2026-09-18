# Sequence Diagram - Course Registration

The following sequence describes the process of registering a student for a course.


Student/User
     |
     | Select Course Registration
     v
+----------------+
|    Main.java   |
+----------------+
     |
     | Enter Student ID
     |
     | Enter Course ID
     v
+-------------------------+
| RegistrationManager     |
+-------------------------+
     |
     | Find Student
     v
+-------------------------+
| StudentManager          |
+-------------------------+
     |
     | Student Found
     v
+-------------------------+
| RegistrationManager     |
+-------------------------+
     |
     | Find Course
     v
+-------------------------+
| CourseManager           |
+-------------------------+
     |
     | Course Found
     v
+-------------------------+
| RegistrationManager     |
+-------------------------+
     |
     | Check Duplicate Registration
     |
     | Check Course Capacity
     v
+-------------------------+
|       Course            |
+-------------------------+
     |
     | Seat Available
     v
+-------------------------+
| RegistrationManager     |
+-------------------------+
     |
     | Create Registration
     v
+-------------------------+
|     Registration        |
+-------------------------+
     |
     | Add Registration
     v
+-------------------------+
|     FileManager         |
+-------------------------+
     |
     | Save Registration
     v
+----------------+
| registrations  |
|     .txt       |
+----------------+
     |
     | Success Message
     v
+----------------+
|    Main.java   |
+----------------+
     |
     | Display Result
     v
Student/User