package methods;
import java.util.*;

public class PointUtils {

    // Method to calculate Euclidean distance between two points
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {

        // distance = sqrt((x2-x1)^2 + (y2-y1)^2)
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find the equation of a line (y = m*x + b) given two points
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m, b;
        if (x2 - x1 == 0) {
            // To avoid division by zero for vertical line
            m = Double.POSITIVE_INFINITY; // slope is undefined
            b = Double.NaN; // y-intercept is not defined for vertical line
        } else {
            m = (y2 - y1) / (x2 - x1); // slope
            b = y1 - m * x1;            // y-intercept
        }
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scn.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scn.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scn.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scn.nextDouble();

        // Calculate Euclidean distance
        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance between points: " + distance);

        // Calculate equation of the line
        double[] equation = lineEquation(x1, y1, x2, y2);

        if (Double.isInfinite(equation[0])) {

            System.out.println("The line is vertical. Equation: x = " + x1);
            
        } else {
            System.out.println("Equation of the line: y = " + equation[0] + "x + " + equation[1]);
        }
    }
}

