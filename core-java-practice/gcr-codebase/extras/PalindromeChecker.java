package extras;
import java.util.*;

public class PalindromeChecker {

    // Function to take string input
    static String Input() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return scn.nextLine();
    }
    // Function to check if the string is a palindrome
    static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase(); // ignore spaces and case
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    // Function to display result
    static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println("\"" + str + "\" is a palindrome.");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome.");
        }
    }
    public static void main(String[] args) {
        String input = Input();
        boolean result = isPalindrome(input);
        displayResult(input, result);
    }
}

