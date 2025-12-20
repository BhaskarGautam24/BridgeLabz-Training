import java.util.*;

public class LeapYear {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scn.nextInt();

        // Check for Gregorian calendar
        if (year < 1582) {
            System.out.println("Year should be 1582 or later.");
        }
        else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Year is a Leap Year");
        } 
        else {
            System.out.println("Year is not a Leap Year");
        }
    }
}

