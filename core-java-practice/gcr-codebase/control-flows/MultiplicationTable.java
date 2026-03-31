import java.util.*;

class MultiplicationTable {
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        for (int i = 6; i <= 9; i++) {               // prints multiplication table from 6 to 9
            System.out.println(number + " * " + i + " = " + (number * i));
        }
    }
}

