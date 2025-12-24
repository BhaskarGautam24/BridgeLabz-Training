import java.util.*;
public class UniversityManagementDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rollNumber = scn.nextInt();
        scn.nextLine();
        String name = scn.nextLine();
        double cgpa = scn.nextDouble();

        // creating postgraduate student object
        PostgraduateStudent pgStudent = new PostgraduateStudent(rollNumber, name, cgpa);

        // displaying student details
        pgStudent.showStudentInfo();

        // updating cgpa using setter
        double newCgpa = scn.nextDouble();
        pgStudent.setCgpa(newCgpa);

        // showing updated cgpa
        System.out.println("updated cgpa: " + pgStudent.getCgpa());
    }
}

// base class for student
class Student {

    // public variable
    public int rollNumber;

    // protected variable
    protected String name;

    // private variable
    private double cgpa;

    // parameterized constructor
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // getter for cgpa
    public double getCgpa() {
        return cgpa;
    }

    // setter for cgpa
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

// subclass to show protected usage
class PostgraduateStudent extends Student {

    // constructor calling parent
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }
    public void showStudentInfo() {
        System.out.println("roll number: " + rollNumber);
        System.out.println("name: " + name);
        System.out.println("cgpa: " + getCgpa());
    }
}

