import java.util.*;

class RocketCountdown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int counter = scn.nextInt();
        while (counter >= 1) {                       // use to print countdown from given number to 1
            System.out.println(counter);
            counter--;
        }
    }
}

