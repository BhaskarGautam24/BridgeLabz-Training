import java.util.*;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scn.nextInt();
        int originalNumber = number;
        int sum = 0;

        // Calculate sum of digits
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += digit;
            originalNumber /= 10;
        }

        // Check if number is divisible by sum of digits
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }
    }
}
