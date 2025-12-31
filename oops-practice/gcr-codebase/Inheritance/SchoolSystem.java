import java.util.*;
public class SchoolSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;

        // teacher specific
        String subject;

        // student specific
        String grade;

        // staff specific
        String department;

        // taking teacher details
        System.out.println("enter teacher name:");
        name = sc.nextLine();

        System.out.println("enter teacher age:");
        age = sc.nextInt();
        sc.nextLine();

        System.out.println("enter subject:");
        subject = sc.nextLine();

        // parent reference for teacher
        Person p1 = new Teacher(name, age, subject);
        p1.displayRole();

        // taking student details
        System.out.println("enter student name:");
        name = sc.nextLine();

        System.out.println("enter student age:");
        age = sc.nextInt();
        sc.nextLine();

        System.out.println("enter grade:");
        grade = sc.nextLine();

        // parent reference for student
        Person p2 = new Student(name, age, grade);
        p2.displayRole();

        // taking staff details
        System.out.println("enter staff name:");
        name = sc.nextLine();

        System.out.println("enter staff age:");
        age = sc.nextInt();
        sc.nextLine();

        System.out.println("enter department:");
        department = sc.nextLine();

        // parent reference for staff
        Person p3 = new Staff(name, age, department);
        p3.displayRole();
    }
}

// parent class person
class Person {

    // common variables
    private String name;
    private int age;

    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for age
    public int getAge() {
        return age;
    }

    // role method
    public void displayRole() {
        System.out.println("person in school");
    }
}

// teacher class
class Teacher extends Person {

    // teacher variable
    private String subject;

    // constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // showing role
    @Override
    public void displayRole() {
        System.out.println(getName() + " is a teacher");
        System.out.println("subject: " + subject);
    }
}

// student class
class Student extends Person {

    // student variable
    private String grade;

    // constructor
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    // showing role
    @Override
    public void displayRole() {
        System.out.println(getName() + " is a student");
        System.out.println("grade: " + grade);
    }
}

// staff class
class Staff extends Person {

    // staff variable
    private String department;

    // constructor
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // showing role
    @Override
    public void displayRole() {
        System.out.println(getName() + " is a staff member");
        System.out.println("department: " + department);
    }
}

