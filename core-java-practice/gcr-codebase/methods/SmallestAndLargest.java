package methods;
import java.util.*;
public class SmallestAndLargest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = scn.nextInt();

        System.out.print("Enter second number: ");
        int number2 = scn.nextInt();

        System.out.print("Enter third number: ");
        int number3 = scn.nextInt();

        int[] result = findSmallestAndLargest(number1, number2, number3); // calling method to find smallest and largest

        System.out.println("Smallest number is: " + result[0]);
        System.out.println("Largest number is: " + result[1]);
    }

    // Method to find the smallest and largest of three numbers
    static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }
}
