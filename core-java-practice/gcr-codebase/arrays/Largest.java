package arrays;
import java.util.*;
public class Largest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scn.nextInt();
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
         // Store digits in the array
        while (number != 0) {
            if (index == maxDigit) {
                break; // Stop if we reach the max size of the array
            }
            digits[index++] = number % 10;
            number /= 10;
        }
        // Find largest and second largest digits
        int largest = -1;
        int secondLargest = -1;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        // Display the results
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("There is no second largest digit.");
        }
    }
}