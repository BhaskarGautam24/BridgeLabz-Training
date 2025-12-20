import java.util.*;

public class PowerFor {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        int power = scn.nextInt();
        int result = 1;

        for (int i = 1; i <= power; i++) {           // loop from 1 to power
            result = result * number;
        }
       System.out.println("Result: " + result);
    }
}
