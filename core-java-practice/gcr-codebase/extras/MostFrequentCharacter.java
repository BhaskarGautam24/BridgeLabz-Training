package extras;
import java.util.*;
public class MostFrequentCharacter {
    // Function to find the most frequent character
    static char mostFrequentChar(String str) {
        int[] freq = new int[256];            // frequency array for all ASCII characters
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        int max = 0;
        char mostFrequent = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] > max) {
                max = freq[str.charAt(i)];
                mostFrequent = str.charAt(i);
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scn.nextLine();

        char result = mostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + result + "'");
    }
}

