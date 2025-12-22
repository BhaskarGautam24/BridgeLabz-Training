import java.util.*;
public class ShortestAndLongestWord {
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

    // Method to split text into words without using split()
    public static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = 0;
        boolean isWord = false;

        // Count words
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !isWord) {
                wordCount++;
                isWord = true;
            } else if (text.charAt(i) == ' ') {
                isWord = false;
            }
        }

        // Store space indexes
        int[] spaceIndex = new int[wordCount + 1];
        int index = 0;
        spaceIndex[index++] = -1;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }
        spaceIndex[index] = length;

        // Extract words
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = text.substring(spaceIndex[i] + 1, spaceIndex[i + 1]);
        }

        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestAndLongest(String[][] wordData) {
        int shortest = 0;
        int longest = 0;

        for (int i = 1; i < wordData.length; i++) {
            int currentLength = Integer.parseInt(wordData[i][1]);

            if (currentLength < Integer.parseInt(wordData[shortest][1])) {
                shortest = i;
            }

            if (currentLength > Integer.parseInt(wordData[longest][1])) {
                longest = i;
            }
        }

        return new int[]{shortest, longest};
    }

    // Main method
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scn.nextLine();

        String[] words = customSplit(text);
        String[][] wordData = wordWithLength(words);
        int[] result = findShortestAndLongest(wordData);
        for (String[] row : wordData) {                                           // Display word data
            System.out.println(row[0] + " -> " + row[1]);
        }

        System.out.println("\nShortest Word: " + wordData[result[0]][0]);
        System.out.println("Longest Word: " + wordData[result[1]][0]);
    }
}
