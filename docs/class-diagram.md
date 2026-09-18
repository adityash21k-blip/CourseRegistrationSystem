# Class Diagram


+-------------------------+
|        Student          |
+-------------------------+
| - studentId: String     |
| - name: String          |
| - email: String         |
| - program: String       |
+-------------------------+
| + Student(...)          |
| + getStudentId()        |
| + getName()             |
| + getEmail()            |
| + getProgram()          |
| + toString()            |
| + toFileString()        |
+-------------------------+


+-------------------------+
|         Course          |
+-------------------------+
| - courseId: String      |
| - courseName: String    |
| - credits: int          |
| - capacity: int         |
| - enrolledStudents:int  |
+-------------------------+
| + Course(...)           |
| + isFull()              |
| + enrollStudent()       |
| + removeStudent()       |
| + getAvailableSeats()   |
| + toString()            |
| + toFileString()        |
+-------------------------+


+-------------------------+
|      Registration       |
+-------------------------+
| - studentId: String     |
| - courseId: String      |
+-------------------------+
| + Registration(...)     |
| + getStudentId()        |
| + getCourseId()         |
| + toString()            |
| + toFileString()        |
+-------------------------+


+-------------------------+
|    StudentManager      |
+-------------------------+
| - students: ArrayList   |
+-------------------------+
| + addStudent()          |
| + displayStudents()     |
| + findStudent()         |
| + removeStudent()       |
| + getStudents()         |
+-------------------------+


+-------------------------+
|     CourseManager       |
+-------------------------+
| - courses: ArrayList    |
+-------------------------+
| + addCourse()           |
| + displayCourses()      |
| + findCourse()          |
| + removeCourse()        |
| + getCourses()          |
+-------------------------+


+-------------------------------+
|    RegistrationManager        |
+-------------------------------+
| - registrations: ArrayList    |
| - studentManager              |
| - courseManager               |
+-------------------------------+
| + registerStudent()           |
| + isAlreadyRegistered()       |
| + dropCourse()                |
| + displayStudentCourses()     |
| + displayCourseAvailability() |
| + displayAllRegistrations()   |
+-------------------------------+


+-------------------------+
|      FileManager       |
+-------------------------+
| + initializeFiles()    |
| + saveStudents()       |
| + loadStudents()       |
| + saveCourses()        |
| + loadCourses()        |
| + saveRegistrations()  |
| + loadRegistrations()  |
+-------------------------+


+-------------------------+
|    InputValidator      |
+-------------------------+
| + isEmpty()            |
| + isPositiveInteger()  |
| + isValidEmail()       |
| + parsePositiveInteger()|
+-------------------------+