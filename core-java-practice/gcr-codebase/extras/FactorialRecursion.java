package extras;
import java.util.*;
public class FactorialRecursion {
  // Function to take input
    static int Input() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        return scn.nextInt();
    }
// Recursive function to calculate factorial
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
 // Function to display result
    static void displayResult(int n, long fact) {
        System.out.println("Factorial of " + n + " is: " + fact);
    }
    public static void main(String[] args) {
        int num = Input();
        long result = factorial(num);
        displayResult(num, result);
    }
}

