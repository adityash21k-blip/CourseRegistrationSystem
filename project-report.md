# COURSE REGISTRATION SYSTEM

## VITyarthi - Build Your Own Project

### Project Report

**Project Title:** Course Registration System

**Programming Language:** Java

**Development Environment:** Visual Studio Code

**Student Name:** Aditya Sahu

**Registration Number:** 25BAI11538

**Course:** Programming in Java

**Academic Year:** 2026

---

# 1. Introduction

The Course Registration System is a Java-based command-line application developed to manage student information, course information, and course registrations.

The system provides separate modules for managing students, managing courses, and handling course registrations. It also provides registration reporting and file-based data storage.

The project demonstrates the application of Java programming concepts including object-oriented programming, classes and objects, encapsulation, ArrayList, file handling, exception handling, input validation, and modular programming.

---

# 2. Problem Statement

Managing student course registrations manually can make it difficult to maintain accurate records of students, courses, registrations, and available course seats.

The Course Registration System provides a computerized solution for managing these activities through a simple command-line interface.

The system allows student and course records to be maintained and provides functionality for registering students for courses and dropping courses.

The system also validates registration requests to prevent duplicate registrations and registration when a course has reached its capacity.

---

# 3. Objectives

The objectives of the project are:

1. To manage student information.
2. To manage course information.
3. To allow students to register for courses.
4. To allow students to drop registered courses.
5. To prevent duplicate course registrations.
6. To prevent registration when a course is full.
7. To provide course availability information.
8. To generate registration reports.
9. To store application data using files.
10. To demonstrate Java and object-oriented programming concepts.

---

# 4. Functional Requirements

## 4.1 Student Management

- Add a new student.
- View all students.
- Search for a student using Student ID.
- Remove a student.
- Prevent duplicate Student IDs.

## 4.2 Course Management

- Add a new course.
- View all courses.
- Search for a course using Course ID.
- Remove a course.
- Store course credits.
- Store course capacity.
- Display available seats.

## 4.3 Course Registration

- Register a student for a course.
- Drop a registered course.
- View courses registered by a student.
- Check course availability.
- Prevent duplicate registration.
- Prevent registration when a course is full.
- Verify that the student exists.
- Verify that the course exists.

## 4.4 Registration Reporting

- Display all registrations.
- Display registered student information.
- Display course information.

## 4.5 Data Management

- Save student information.
- Save course information.
- Save registration information.
- Load stored data when the application starts.

---

# 5. Non-Functional Requirements

## 5.1 Usability

The system provides a simple menu-driven command-line interface that allows users to navigate between different operations.

## 5.2 Reliability

The application validates operations and handles invalid inputs without terminating unexpectedly.

## 5.3 Performance

The application performs normal student, course, and registration operations efficiently for the intended project scale.

## 5.4 Error Handling

The system handles invalid numeric input, empty input, invalid student IDs, invalid course IDs, duplicate registrations, and full courses.

## 5.5 Maintainability

The application is divided into multiple classes, with each class responsible for a specific part of the system.

## 5.6 Resource Efficiency

The application uses Java collections and text files for lightweight data management.

## 5.7 Security

The system validates user-provided information before processing and storing records.

---

# 6. System Architecture

The system follows a modular architecture.

The user interacts with the application through the command-line interface implemented in Main.java.

The manager classes perform the main application operations. StudentManager manages student records, CourseManager manages course records, and RegistrationManager handles course registration operations.

FileManager provides persistent file storage, while InputValidator handles validation.

The architecture diagram is available in:

`docs/architecture.md`

---

# 7. Workflow

The general workflow of the application is:

1. Start the application.
2. Display the main menu.
3. Select a required module.
4. Enter the required information.
5. Validate the input.
6. Process the requested operation.
7. Save updated data where required.
8. Display the result.
9. Return to the main menu.
10. Exit the application.

The detailed workflow is available in:

`docs/workflow.md`

---

# 8. Use Case Diagram

The major actors of the system are Student and Administrator.

The main use cases include:

- Add Student
- View Students
- Search Student
- Add Course
- View Courses
- Search Course
- Register Course
- Drop Course
- View Registered Courses
- Check Course Availability
- View Registration Report

The use case documentation is available in:

`docs/use-case.md`

---

# 9. Sequence Diagram

The sequence diagram describes the course registration process.

The registration process involves:

1. User selecting course registration.
2. Entering Student ID.
3. Entering Course ID.
4. Checking whether the student exists.
5. Checking whether the course exists.
6. Checking duplicate registration.
7. Checking course capacity.
8. Creating a registration.
9. Updating course enrollment.
10. Saving the registration.
11. Displaying the result.

The sequence diagram is available in:

`docs/sequence-diagram.md`

---

# 10. Class Diagram

The main classes used in the system are:

- Main
- Student
- Course
- Registration
- StudentManager
- CourseManager
- RegistrationManager
- FileManager
- InputValidator

The class diagram documentation is available in:

`docs/class-diagram.md`

---

# 11. Data Storage Design

The system uses text files for persistent storage.

The following files are used:

### students.txt

Stores student information.

### courses.txt

Stores course information.

### registrations.txt

Stores student-course registration information.

The file-based approach provides simple persistent storage without requiring an external database.

---

# 12. Design Decisions and Rationale

## Modular Design

Separate manager classes were created so that student, course, and registration operations are handled independently.

## Object-Oriented Design

Student, Course, and Registration are represented using separate classes. This makes the application easier to understand and maintain.

## ArrayList

ArrayList is used to store collections of students, courses, and registrations dynamically.

## File Handling

Text files are used to provide persistent storage without requiring additional database software.

## Input Validation

Input validation is implemented to reduce invalid data and prevent common application errors.

---

# 13. Implementation Details

## Student.java

Represents a student and stores Student ID, name, email, and program.

## Course.java

Represents a course and stores Course ID, course name, credits, capacity, and enrolled student count.

## Registration.java

Represents a registration between a student and a course.

## StudentManager.java

Handles adding, viewing, searching, and removing students.

## CourseManager.java

Handles adding, viewing, searching, and removing courses.

## RegistrationManager.java

Handles course registration, dropping courses, duplicate checking, and course availability.

## FileManager.java

Handles saving and loading student, course, and registration data.

## InputValidator.java

Provides input validation methods.

## Main.java

Provides the command-line interface and controls the application workflow.

---

# 14. Screenshots / Results

## 14.1 Main Menu

[Insert Screenshot Here]

The main menu provides access to all major modules.

## 14.2 Student Management

[Insert Screenshot Here]

The system successfully displays and manages student records.

## 14.3 Course Management

[Insert Screenshot Here]

The system displays courses, credits, capacity, enrollment, and available seats.

## 14.4 Successful Course Registration

[Insert Screenshot Here]

The system successfully registers a student for an available course.

## 14.5 Registration Report

[Insert Screenshot Here]

The system displays existing student-course registrations.

## 14.6 Error Handling

[Insert Screenshot Here]

The system prevents duplicate course registration and displays an appropriate error message.

---

# 15. Testing Approach

Testing was performed using functional test cases.

| Test Case | Input/Operation | Expected Result |
|---|---|---|
| TC01 | View students | Student records displayed |
| TC02 | Search valid Student ID | Student details displayed |
| TC03 | Search invalid Student ID | Student not found |
| TC04 | View courses | Course records displayed |
| TC05 | Search valid Course ID | Course details displayed |
| TC06 | Register valid student for valid course | Registration successful |
| TC07 | Register same student again | Duplicate registration rejected |
| TC08 | Check course availability | Available seats displayed |
| TC09 | Drop registered course | Course dropped successfully |
| TC10 | Enter invalid numeric input | Error message displayed |

---

# 16. Challenges Faced

During development, challenges included organizing the application into separate Java classes, handling relationships between students, courses, and registrations, implementing file-based persistence, and validating user input.

Another challenge was ensuring that course enrollment counts remained consistent when students registered for or dropped courses.

---

# 17. Learnings and Key Takeaways

The project provided practical experience with:

- Java object-oriented programming.
- Classes and objects.
- Encapsulation.
- ArrayList and collections.
- File handling.
- Exception handling.
- Input validation.
- Modular application design.
- Command-line application development.
- Git and GitHub version control.
- Software documentation and testing.

---

# 18. Future Enhancements

Future versions of the system could include:

- Graphical User Interface.
- Database integration.
- Student authentication.
- Administrator authentication.
- Semester-wise registration.
- Course prerequisites.
- Maximum credit limits.
- Course timetable management.
- Advanced reports.
- Web-based access.

---

# 19. Conclusion

The Course Registration System provides a functional Java-based solution for managing students, courses, and course registrations through a command-line interface.

The project demonstrates important Java programming concepts and provides features such as registration validation, course capacity management, file-based persistence, and registration reporting.

The modular structure makes the system easier to understand, maintain, and extend with additional functionality in the future.

---

# 20. References

1. Java Documentation - Oracle.
2. Java Platform documentation and standard library references.
3. VITyarthi Build Your Own Project instructions.
4. Course material provided for Programming in Java.