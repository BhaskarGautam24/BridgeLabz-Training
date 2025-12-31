class Student {

    String name;
    String rollNumber;
    double mark1, mark2, mark3;

    Student(String name, String rollNumber, double mark1, double mark2, double mark3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    String calculateGrade() {                    // Calculate average and determine grade
        double avg = (mark1 + mark2 + mark3) / 3;

        if (avg >= 75)
            return "A";
        else if (avg >= 60)
            return "B";
        else
            return "C";
    }

    void displayReport() {                         // Display student report
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
        System.out.println();
    }
}

public class StudentReport {
    public static void main(String[] args) {

        Student s1 = new Student("Thamarai", "ECE001", 80.0, 70.0, 75.0);

        Student s2 = new Student("Kannan", "CSC002", 60.0, 65.0, 50.0);

        s1.displayReport();
        s2.displayReport();
    }
}

