import java.util.*;

public class FactorsWhile {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scn.nextInt();
         // Check for positive integer
        if (number <= 0) {
            System.out.println("no. is not positive");
        } else {
            int i = 1;   

            // while loop till i < number
            while (i < number) {
                if (number % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        }
    }
}
