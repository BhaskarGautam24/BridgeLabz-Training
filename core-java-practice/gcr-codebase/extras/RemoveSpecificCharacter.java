package extras;
import java.util.*;

public class RemoveSpecificCharacter {
    // Function to remove a specific character
    static String removeCharacter(String str, char chToRemove) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != chToRemove) {
                result += ch;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scn.nextLine();

        System.out.print("Enter the character to remove: ");
        char ch = scn.next().charAt(0);

        String output = removeCharacter(input, ch);
        System.out.println("Modified string: " + output);
    }
}

