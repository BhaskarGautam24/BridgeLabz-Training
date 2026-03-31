package arrays;
import java.util.*;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number to find digit frequency: ");
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
      // Find frequency of each digit
        int[] frequency = new int[10]; // Digits range from 0 to 9
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        // Display the frequency of each digit
        System.out.println("Digit frequencies in the number " + number + ":");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
    }
}
