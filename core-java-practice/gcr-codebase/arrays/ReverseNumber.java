package arrays;
import java.util.*;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        int number = scn.nextInt();
        // Count digits in the number
        int temp = number;
        int digitCount = 0;
        while (temp != 0) {
            digitCount++;
            temp /= 10;
        }
        // Store digits in an array
        int[] digits = new int[digitCount];
        temp = number;
        for (int i = 0; i < digitCount; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        
        // Display the digits in reverse order
        System.out.print("Reversed number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
