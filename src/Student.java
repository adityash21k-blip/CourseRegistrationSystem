public class Student{
    private String studentId;
    private String name;
    private String email;
    private String program;

    public Student(String studentId, String name, String email, String program){
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.program = program;
    }

    public String getStudentId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getProgram(){
        return program;
    }

    @Override
    public String toString(){
        return "ID: " + studentId +
               " | Name: " + name +
               " | Email: " + email +
               " | Program: " + program;
    }

    public String toFileString(){
        return studentId + "," + name + "," + email + "," + program;
    }
}
