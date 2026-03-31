package methods;
import java.util.*;
public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scn.nextInt();

        int maxHandshakes = calculateMaxHandshakes(numberOfStudents); // calling method to calculate maximum handshakes

        System.out.printf("The maximum number of handshakes among %d students is: %d%n", numberOfStudents, maxHandshakes);
    }

    // Method to calculate maximum handshakes
    static int calculateMaxHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
