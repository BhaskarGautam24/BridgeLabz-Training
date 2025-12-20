import java.util.*;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            for (int i = 1; i <= number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // Check for multiple of 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // Check for multiple of 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
                else {
                    System.out.println(i);
                }
            }
        }
    }
}

