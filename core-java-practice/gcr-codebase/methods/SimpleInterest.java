package methods;
import java.util.*;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter Principal amount: ");
        double principal = scn.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = scn.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scn.nextDouble();

        double simpleInterest = calculateSimpleInterest(principal, rate, time);     //calling method to calculate simple interest

        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f years%n",
                simpleInterest, principal, rate, time);
    }

    // Method to calculate simple interest
    static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}