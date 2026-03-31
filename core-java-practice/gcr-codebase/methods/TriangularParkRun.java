package methods;
import java.util.*;
public class TriangularParkRun {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter side 1 of the triangular park (in meters): ");
        double side1 = scn.nextDouble();
        System.out.print("Enter side 2 of the triangular park (in meters): ");
        double side2 = scn.nextDouble();
        System.out.print("Enter side 3 of the triangular park (in meters): ");
        double side3 = scn.nextDouble();

        int rounds = calculateRoundsFor5kmRun(side1, side2, side3); // calling method to calculate number of rounds

        System.out.printf("To complete a 5 km run, the athlete must complete %d rounds in the triangular park.%n", rounds);
    }
    // Method to calculate number of rounds needed to complete 5 km run
    static int calculateRoundsFor5kmRun(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;          // Calculate perimeter of the triangular park
        double distanceToRun = 5000;          // 5 km in meters
        return (int) Math.ceil(distanceToRun / perimeter);        // Calculate and return number of rounds
    }
}