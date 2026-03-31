import java.util.*;

class FactorialUsingFor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Factorial cannot be computed for non-positive integers.");
        } else {

            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i;
            }
            System.out.println("Factorial of " + number + " is: " + factorial);
        }
    }
}
