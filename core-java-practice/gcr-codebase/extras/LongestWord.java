package extras;
import java.util.*;

public class LongestWord {

    // Function to find the longest word
    static String findLongestWord(String sentence) {
        String[] words = sentence.split(" "); // split sentence into words
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String longestWord = findLongestWord(input);
        System.out.println("The longest word is: " + longestWord);
    }
}
