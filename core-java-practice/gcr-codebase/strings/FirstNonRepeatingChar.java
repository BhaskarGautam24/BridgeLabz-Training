package strings;
import java.util.*;
public class FirstNonRepeatingChar {
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
    // Method to find the first non-repeating character
    public static char firstNonRepeatingCharacter(String text) {
        int length = findLength(text);
        int[] frequency = new int[256];                            // ASCII character set size

        // Calculate frequency of each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            frequency[(int) currentChar]++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            if (frequency[(int) currentChar] == 1) {
                return currentChar;
            }
        }

        return '\0'; // Return null character if no non-repeating character is found
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scn.nextLine();

        char result = firstNonRepeatingCharacter(text);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}