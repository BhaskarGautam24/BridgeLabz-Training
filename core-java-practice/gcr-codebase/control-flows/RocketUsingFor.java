import java.util.*;

class RocketCountdown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int counter = scn.nextInt();
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Rocket Launched!");
    }
}
