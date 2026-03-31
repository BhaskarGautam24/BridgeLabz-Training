import java.util.*;
public class ArmStrong {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scn.nextInt();
        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum += Math.pow(digit, 3);
            originalNumber /= 10;
        }

        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}

