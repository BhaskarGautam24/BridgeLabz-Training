package extras;
import java.util.*;

public class RemoveDuplicates {

    // Function to remove duplicate characters
    static String removeDuplicates(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (result.indexOf(ch) == -1) {                     // if character not already in result
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scn.nextLine();

        String output = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + output);
    }
}

