package strings;
import java.util.*;
public class StringComparison {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scn.next();
        System.out.print("Enter the second string: ");
        String str2 = scn.next();

        boolean charAtComparisonResult = compareStringsUsingCharAt(str1, str2);
        boolean equalsMethodResult = str1.equals(str2);
        if (charAtComparisonResult == equalsMethodResult) {
            System.out.println("Both methods yield the same result.");
        } else {
            System.out.println("The methods yield different results.");
        }
    }

    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

