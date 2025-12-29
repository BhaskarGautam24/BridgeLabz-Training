import java.util.*;
// Node class
class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
// Linked List class
class StudentList {

    StudentNode head;
    // Add at end
    void addStudent(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }
    // Delete by roll number
    void deleteStudent(int rollNumber) {

        if (head == null) {
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    // Search student
    void searchStudent(int rollNumber) {

        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found: " + temp.name + " Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found");
    }
    // Update grade
    void updateGrade(int rollNumber, char newGrade) {

        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }
    // Display students
    void displayStudents() {

        StudentNode temp = head;

        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.grade);
            temp = temp.next;
        }
    }
}
public class StudentRecord {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        StudentList list = new StudentList();

        list.addStudent(1, "Rahul", 20, 'A');
        list.addStudent(2, "Ankit", 21, 'B');
        list.displayStudents();
        list.searchStudent(1);
        list.updateGrade(2, 'A');
        list.deleteStudent(1);
        list.displayStudents();
    }
}
