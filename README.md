Course Registration System

1. Project Title

Course Registration System

 2. Overview

The Course Registration System is a Java-based command-line application designed to manage students, courses, and course registrations.

The system provides separate modules for student management, course management, and course registration. It also provides registration reports and stores data using text files so that information can be retained between program executions.

The project demonstrates object-oriented programming, collections, file handling, input validation, exception handling, and modular software design in Java.

 3. Objectives

The main objectives of this project are:

- To manage student information efficiently.
- To manage available courses.
- To allow students to register for available courses.
- To allow students to drop registered courses.
- To prevent duplicate registrations.
- To prevent registration when a course is full.
- To provide registration and course availability information.
- To store application data using files.
- To demonstrate Java programming and object-oriented programming concepts.

 4. Features

## Student Management

- Add a new student.
- View all students.
- Search for a student using Student ID.
- Remove a student.
- Prevent duplicate Student IDs.

## Course Management

- Add a new course.
- View all courses.
- Search for a course using Course ID.
- Remove a course.
- Set course credits.
- Set course capacity.
- Display available seats.

## Course Registration

- Register a student for a course.
- Drop a registered course.
- View courses registered by a student.
- Check course availability.
- Prevent duplicate registration.
- Prevent registration when the course is full.
- Validate student and course IDs.

## Registration Report

- Display all course registrations.
- Display registered student information.
- Display course information.

## Data Management

- Store student information in a text file.
- Store course information in a text file.
- Store registration information in a text file.
- Load stored data when the application starts.
- Save updated data during application execution.

 5. Technologies Used

- Java
- JDK 17 or later
- Visual Studio Code
- Java Collections Framework
- File Handling
- Git
- GitHub

 6. Project Structure

CourseRegistrationSystem
│
├── src
    ├── Main.java
│   ├── Student.java
    ├── Course.java
│   ├── Registration.java
│   ├── StudentManager.java
    ├── CourseManager.java
│   ├── RegistrationManager.java
│   ├── FileManager.java
│   └── InputValidator.java
│
├── data
│   ├── students.txt
    ├── courses.txt
│   └── registrations.txt
│
├── README.md
├── statement.md
└── .gitignore

