import java.util.*;

public class PowerWhile {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int power = scn.nextInt();
        int result = 1;
        int counter = 0;

        while (counter < power) {
            result = result * number;
            counter++;
        }
        System.out.println("Result: " + result);
    }
}

