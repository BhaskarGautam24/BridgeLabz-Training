import java.util.*;

public class BmiCalculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter weight (in kg): ");
        double weight = scn.nextDouble();

        System.out.print("Enter height (in cm): ");
        double heightCm = scn.nextDouble();
        double heightMeter = heightCm / 100;

        // Calculate BMI
        double bmi = weight / (heightMeter * heightMeter);
        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        System.out.println("\nBMI Value: " + bmi);
        System.out.println("Weight Status: " + status);
    }
}
