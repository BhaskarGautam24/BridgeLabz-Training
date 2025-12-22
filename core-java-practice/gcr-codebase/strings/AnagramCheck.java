import java.util.*;

public class AnagramCheck {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String text1 = scn.nextLine();

        System.out.print("Enter second text: ");
        String text2 = scn.nextLine();

        boolean result = isAnagram(text1, text2);
        if (result)
            System.out.println("The texts are Anagrams");
        else
            System.out.println("The texts are NOT Anagrams");
    }

    // Method to check anagram
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Find frequency of characters
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
            freq2[s2.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }

        return true;
    }
}
