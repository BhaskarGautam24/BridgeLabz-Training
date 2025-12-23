package methods;
import java.util.*;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scn.nextInt();

        int result = checkNumber(number); // calling method to check number

        if (result == 1)
            System.out.println("The number is Positive.");
        else if (result == -1)
            System.out.println("The number is Negative.");
        else
            System.out.println("The number is Zero.");
    }

    // Method to check whether the number is positive, negative, or zero
    static int checkNumber(int num) {
        if (num > 0)
            return 1;   // Positive
        else if (num < 0)
            return -1;  // Negative
        else
            return 0;   // Zero
    }
}