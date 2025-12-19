import java.util.*;

class SumUntilZero {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double total = 0.0;
        double number;
        number = sc.nextDouble();

        while (number != 0) {
            total = total + number;
            System.out.print("Enter a number: ");
            number = sc.nextDouble();
        }
        System.out.println("The total sum is " + total);
    }
}
