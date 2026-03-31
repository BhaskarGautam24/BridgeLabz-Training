package extras;
import java.util.*;

public class ReverseString {
    // Function to reverse a string
    static String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Reversed string: " + reverse(input));          // calling reverse method and printing result
    }
}
