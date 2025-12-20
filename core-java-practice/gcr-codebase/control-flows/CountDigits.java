import java.util.*;

public class CountDigits {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scn.nextInt();

        int count = 0;
        if (number == 0) {
            count = 1;
        } else {
            while (number != 0) {
                number = number / 10;                             // remove last digit
                count++;                                         // increase count
            }
        }
        System.out.println("Number of digits: " + count);
    }
}
