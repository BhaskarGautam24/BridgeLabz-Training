package methods;
import java.util.*;
public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scn.nextInt();

        int[] factors = findFactors(number); // calling method to find factors

        System.out.println("Factors of " + number + " are: " + Arrays.toString(factors));

        int sum = calculateSum(factors);                          // calling method to calculate sum of factors
        int product = calculateProduct(factors);                 // calling method to calculate product of factors
        int sumOfSquares = calculateSumOfSquares(factors);       // calling method to calculate sum of squares of factors

        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumOfSquares);
    }

    // Method to find the factors of the number and return them in an array
    static int[] findFactors(int num) {
        List<Integer> factorList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factorList.add(i);
            }
        }
        // Convert List to array
        int[] factors = new int[factorList.size()];
        for (int i = 0; i < factorList.size(); i++) {
            factors[i] = factorList.get(i);
        }
        return factors;
    }

    // Method to calculate the sum of the factors
    static int calculateSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate the product of the factors
    static int calculateProduct(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate the sum of squares of the factors
    static int calculateSumOfSquares(int[] factors) {
        int sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }
}
