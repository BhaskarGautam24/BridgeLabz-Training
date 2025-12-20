import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();

        if (number <= 1) {
            System.out.println("Please enter a number greater than 1.");
        } else {
            boolean isPrime = true;                                  // Assume the number is prime

            // Loop from 2 to number-1
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false; 
                    break; 
                }
            }
            if (isPrime) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }
    }
}

