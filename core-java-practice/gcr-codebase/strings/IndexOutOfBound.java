
package strings;
import java.util.*;
public class IndexOutOfBound {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scn.nextLine();

        try {
            generateStringIndexOutOfBoundsException(str);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }

        handleStringIndexOutOfBoundsException(str);
    }

    public static void generateStringIndexOutOfBoundsException(String str) {
        
        System.out.println(str.charAt(str.length()));                // This will throw StringIndexOutOfBoundsException
    }

    public static void handleStringIndexOutOfBoundsException(String str) {
        try {
            // Accessing an index beyond the length of the string
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException: Index is out of bounds for the string.");
        }
    }
}