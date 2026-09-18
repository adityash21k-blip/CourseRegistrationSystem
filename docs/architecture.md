# System Architecture

The Course Registration System follows a modular architecture. The user interacts with the command-line interface through the Main class. The management classes handle student, course, and registration operations. FileManager provides persistent file-based storage.


                    +----------------------+
                    |        USER          |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    |      Main.java       |
                    |   Command Line UI    |
                    +----------+-----------+
                               |
             +-----------------+-----------------+
             |                 |                 |
             v                 v                 v
    +----------------+ +----------------+ +----------------------+
    | StudentManager | | CourseManager  | | RegistrationManager  |
    +-------+--------+ +-------+--------+ +----------+-----------+
            |                  |                     |
            v                  v                     v
    +--------------+   +--------------+      +---------------+
    |   Student    |   |    Course    |      | Registration  |
    +--------------+   +--------------+      +---------------+
                               |
                               v
                    +----------------------+
                    |     FileManager      |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    |     File Storage     |
                    | students.txt         |
                    | courses.txt          |
                    | registrations.txt    |
                    +----------------------+

                    +----------------------+
                    |  InputValidator      |
                    +----------------------+