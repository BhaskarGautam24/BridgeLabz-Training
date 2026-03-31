import java.util.*;

class NumberSignCheck {
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        if (number > 0) {
            System.out.println("positive");     
        } else if (number < 0) {
            System.out.println("negative");
        } else {
            System.out.println("zero");      
        }
    }
}

