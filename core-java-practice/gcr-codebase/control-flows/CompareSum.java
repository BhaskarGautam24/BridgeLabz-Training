import java.util.*;

class CompareSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

       
        if (number <= 0) {      
            System.out.println("number " + n + " is not a natural number");
        } else {

            // Sum using while loop
            int sumUsingLoop = 0;
            int i = 1;

            while (i <= n) {
                sumUsingLoop = sumUsingLoop + i;
                i++;
            }

            // Sum using formula
            int sumUsingFormula = number * (number + 1) / 2;

            // Compare both results
            if (sumUsingLoop == sumUsingFormula) {
                System.out.println("Result Verified: Both computations are correct.");
            } else {
                System.out.println("Result Mismatch: Computations are not equal.");
            }
        }
    }
}
