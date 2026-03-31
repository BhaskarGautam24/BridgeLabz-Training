package strings;
import java.util.*;
public class ArrayIndexOutOfBound {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = scn.nextInt();
        scn.nextLine();

        String[] names = new String[n];
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            names[i] = scn.nextLine();
        }

        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        handleArrayIndexOutOfBoundsException(names);
    }

    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println(names[names.length]);               // This will throw ArrayIndexOutOfBoundsException
    }

    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println(names[names.length]);                    // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: Index is out of bounds for the array.");
        }
    }
}
