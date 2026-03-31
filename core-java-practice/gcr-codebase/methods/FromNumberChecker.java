package methods;
import java.util.*;

public class FromNumberChecker {

    // Method to count the digits in a number
    public static int countDigits(int number) {
        int count = 0;
        int num = number;
        if (num == 0) return 1; // Special case for 0
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    // Method to store digits of the number in an array
    public static int[] storeDigits(int number) {
        int length = countDigits(number);
        int[] digits = new int[length];
        int num = number;
        for (int i = length - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    // Method to reverse a digits array
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    // Method to check if a number is palindrome using digits
    public static boolean isPalindrome(int number) {
        int[] original = storeDigits(number);
        int[] reversed = reverseArray(original);
        return compareArrays(original, reversed);
    }

    // Method to check if a number is a duck number using digits array
    public static boolean isDuckNumber(int number) {
        int[] digits = storeDigits(number);
        for (int i = 1; i < digits.length; i++) { // Duck number cannot start with 0
            if (digits[i] == 0) return true;
        }
        return false;
    }

    // Main method to test all methods
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scn.nextInt();

        System.out.println("Count of digits: " + countDigits(number));

        int[] digits = storeDigits(number);
        System.out.println("Digits array: " + Arrays.toString(digits));

        int[] reversed = reverseArray(digits);
        System.out.println("Reversed digits array: " + Arrays.toString(reversed));

        System.out.println("Is palindrome? " + isPalindrome(number));
        System.out.println("Is duck number? " + isDuckNumber(number));
    }
}

