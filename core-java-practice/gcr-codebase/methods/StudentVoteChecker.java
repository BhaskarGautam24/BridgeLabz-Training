package methods;
import java.util.*;
public class StudentVoteChecker {
    // Method to check if a student can vote based on age
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false; // Invalid age
        }
        return age >= 18; // Can vote if age is 18 or above
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numberOfStudents = 10;
        int[] ages = new int[numberOfStudents];
       // Taking user input for ages of students
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            ages[i] = scn.nextInt();
        }
       // Checking voting eligibility for each student
        for (int i = 0; i < numberOfStudents; i++) {
            boolean canVote = canStudentVote(ages[i]);
            if (canVote) {
                System.out.println("Student " + (i + 1) + " with age " + ages[i] + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " with age " + ages[i] + " cannot vote.");
            }
        }
    }
}