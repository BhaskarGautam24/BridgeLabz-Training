import java.util.*;

public class LeapYearIfElse {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scn.nextInt();

        // Check for Gregorian calendar year
        if (year < 1582) {
            System.out.println("Year should be 1582 or later (Gregorian calendar).");
        } 
        else {

            // -------- Part 1: Using multiple if-else statements --------
            if (year % 400 == 0) {
                System.out.println("Leap Year (using multiple if-else)");
            }
            else if (year % 100 == 0) {
                System.out.println("Not a Leap Year (using multiple if-else)");
            }
            else if (year % 4 == 0) {
                System.out.println("Leap Year (using multiple if-else)");
            }
            else {
                System.out.println("Not a Leap Year (using multiple if-else)");
            }

            // -------- Part 2: Using single if with logical operators --------
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println("Leap Year (using single if condition)");
            } else {
                System.out.println("Not a Leap Year (using single if condition)");
            }
        }
    }
}

