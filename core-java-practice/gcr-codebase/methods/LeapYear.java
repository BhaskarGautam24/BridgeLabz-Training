package methods;
import java.util.*;

public class LeapYear {

    // Method to check whether the year is a leap year
    public static boolean isLeapYear(int year) {

        // Leap year works only for Gregorian calendar (year >= 1582)
        if (year < 1582) {
            return false;
        }

        // Leap year conditions
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a year: ");
        int year = scn.nextInt();

        // Checking leap year
        if (isLeapYear(year)) {
            System.out.println("Year " + year + " is a Leap Year.");
        } else {
            System.out.println("Year " + year + " is NOT a Leap Year.");
        }
    }
}

