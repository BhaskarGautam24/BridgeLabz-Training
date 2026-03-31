package methods;
import java.util.*;
public class SumOfNatural {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = scn.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a valid natural number greater than zero.");
            return;
        }
        int sumRecursive = sumOfNaturalRecursive(number); // calling method to calculate sum using recursion
        int sumFormula = sumOfNaturalFormula(number);     // calling method to calculate sum using formula

        System.out.println("Sum of first " + number + " natural numbers (using recursion): " + sumRecursive);
        System.out.println("Sum of first " + number + " natural numbers (using formula): " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("The results from both methods do not match.");
        }
    }
   // Method to find the sum of n natural numbers using recursion
    static int sumOfNaturalRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNaturalRecursive(n - 1);
    }
   // Method to find the sum of n natural numbers using the formula n*(n+1)/2
    static int sumOfNaturalFormula(int n) {
        return n * (n + 1) / 2;
    }
}