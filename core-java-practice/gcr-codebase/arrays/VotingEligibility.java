package arrays;
import java.util.*;

public class VotingEligibility {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int[] age = new int[10];
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < age.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            age[i] = scn.nextInt();
        }

        System.out.println("\nVoting Eligibility Result:");

        for (int i = 0; i < age.length; i++) {

            if (age[i] < 0) {
                System.out.println("Invalid age entered.");
            } 
            else if (age[i] >= 18) {
                System.out.println("The student with the age " + age[i] + " can vote.");
            } 
            else {
                System.out.println("The student with the age " + age[i] + " cannot vote.");
            }
        }
    }
}

