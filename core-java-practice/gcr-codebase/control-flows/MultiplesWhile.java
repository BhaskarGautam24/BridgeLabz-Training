import java.util.*;

public class MultiplesWhile {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int counter = 100;

        if (number > 0 && number < 100) {
            while (counter >= 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }
    }
}

