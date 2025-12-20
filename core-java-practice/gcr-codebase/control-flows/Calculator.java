import java.util.*;

public class Calculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        double first = sc.nextDouble();

        double second = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        String op = sc.next();

        // Switch case for calculator
        switch (op) {
            case "+":
                System.out.println("Result = " + (first + second));
                break;

            case "-":
                System.out.println("Result = " + (first - second));
                break;

            case "*":
                System.out.println("Result = " + (first * second));
                break;

            case "/":
                if (second != 0)
                    System.out.println("Result = " + (first / second));
                else
                    System.out.println("Division by zero not allowed");
                break;

            default:
                System.out.println("Invalid Operator");
        }
    }
}

