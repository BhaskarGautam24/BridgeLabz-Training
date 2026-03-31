package strings;
import java.util.*;
public class CharacterFrequency {
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
    // Method to find frequency of characters in a string
    public static String[][] characterFrequency(String text) {
        int length = findLength(text);
        int[] frequency = new int[256];                            // ASCII character set size
            // Calculate frequency of each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            frequency[(int) currentChar]++;
        }
              // Count unique characters
        int uniqueCount = 0;
        for (int freq : frequency) {
            if (freq > 0) {
                uniqueCount++;
            }
        }
     // Create a 2D array to store characters and their frequencies
        String[][] charFreqArray = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                charFreqArray[index][0] = Character.toString((char) i);
                charFreqArray[index][1] = Integer.toString(frequency[i]);
                index++;
            }
        }
        return charFreqArray;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scn.nextLine();

        String[][] charFrequencies = characterFrequency(text);

        System.out.println("Character Frequencies:");
        for (String[] pair : charFrequencies) {
            System.out.println(pair[0] + " -> " + pair[1]);
        }
    }
}
