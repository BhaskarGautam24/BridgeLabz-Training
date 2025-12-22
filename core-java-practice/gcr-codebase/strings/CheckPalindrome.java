package strings;
import java.util.*;
public class CheckPalindrome {
    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Index out of bounds occurs
        }
        return count;
    }
    // Method to check palindrome using iterative approach
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = findLength(text) - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // Method to check palindrome using recursion
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    // Method to reverse a string using charAt()
    public static char[] reverseString(String text) {
        int length = findLength(text);
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = text.charAt(length - 1 - i);
        }
        return reversed;
    }
    // Method to check palindrome using character arrays
    public static boolean isPalindromeUsingArrays(String text) {
        char[] originalArray = text.toCharArray();
        char[] reversedArray = reverseString(text);
        int length = findLength(text);

        for (int i = 0; i < length; i++) {
            if (originalArray[i] != reversedArray[i]) {
                return false;
            }
        }
        return true;
    }
    // Main method
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scn.nextLine();

        // Check palindrome using iterative approach
        boolean resultIterative = isPalindromeIterative(text);
        System.out.println("Is Palindrome (Iterative): " + resultIterative);

        // Check palindrome using recursion
        boolean resultRecursive = isPalindromeRecursive(text, 0, findLength(text) - 1);
        System.out.println("Is Palindrome (Recursive): " + resultRecursive);

        // Check palindrome using character arrays
        boolean resultUsingArrays = isPalindromeUsingArrays(text);
        System.out.println("Is Palindrome (Using Arrays): " + resultUsingArrays);
    }
}

