package extras;
import java.util.*;

public class BasicCalculator {
   // Function for addition
    static double add(double a, double b) {
        return a + b;
    }
    // Function for subtraction
    static double subtract(double a, double b) {
        return a - b;
    }
    // Function for multiplication
    static double multiply(double a, double b) {
        return a * b;
    }
    // Function for division
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return Double.NaN;
        }
        return a / b;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scn.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scn.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        char op = scn.next().charAt(0);

        double result;
        switch (op) {
            case '+': result = add(num1, num2); break;
            case '-': result = subtract(num1, num2); break;
            case '*': result = multiply(num1, num2); break;
            case '/': result = divide(num1, num2); break;
            default: 
                System.out.println("Invalid operator!");
                return;
        }

        System.out.println("Result: " + result);
    }
}

