import java.util.*;

public class Factors {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();

        // Check for positive integer
        if (number <= 0) {
            System.out.println("no. is not positive");
        } else {

            System.out.println("Factors of " + number + " are:");

           
            for (int i = 1; i < number; i++) {                    //loop from 1 to number-1
                if (number % i == 0) {                    
                    System.out.println(i);
                }
            }
        }
    }
}
