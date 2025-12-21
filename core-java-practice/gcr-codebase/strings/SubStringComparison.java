package strings;
import java.util.*;

public class SubStringComparison {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = scn.nextLine();

        System.out.print("Enter start index: ");
        int start = scn.nextInt();

        System.out.print("Enter end index: ");
        int end = scn.nextInt();

        String subCharAt = createSubstring(str, start, end);
        String subBuiltIn = str.substring(start, end);

        System.out.println("Substring using charAt(): " + subCharAt);
        System.out.println("Substring using substring(): " + subBuiltIn);

        System.out.println("Are both substrings equal? " +
                compareStrings(subCharAt, subBuiltIn));
    }

    static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}
