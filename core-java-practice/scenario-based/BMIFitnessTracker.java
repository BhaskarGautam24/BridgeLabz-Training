import java.util.*;
public class BMIFitnessTracker {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter your height in centimeters: ");
    double heightCm = scn.nextDouble();
    System.out.println("Enter your weight in kilograms: ");
    double weightKg = scn.nextDouble();
    double heightM = heightCm / 100;                // convert height to meters

    double bmi = weightKg / (heightM * heightM);    // calculate BMI

    String Status;
    if(bmi <= 18.4){
      Status = "Underweight";
      System.out.println("You are underweight, please consult a nutritionist.");
    }
    else if(bmi <= 24.9){
      Status = "Normal";
      System.out.println("You have a normal weight, keep up the good work!");
    }
    else {
      Status = "Overweight";
      System.out.println("You are overweight, consider a fitness plan.");
    }  
  }
  
}
