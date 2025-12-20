import java.util.*;

public class GreatestFactorWhile {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int greatestFactor = 1;
        int counter = number - 1;

        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break;
            }
            counter--;
        }
        System.out.println("Greatest factor: " + greatestFactor);
    }
}
