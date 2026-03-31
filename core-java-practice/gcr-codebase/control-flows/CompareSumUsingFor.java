import java.util.*;

class CompareSumUsingFor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Check whether the number is a Natural number
        if (n <= 0) {
            System.out.println("Number is not a Natural number");
        } else {
            int sumUsingForLoop = 0;

            for (int i = 1; i <= n; i++) {
                sumUsingForLoop = sumUsingForLoop + i;
            }

            // Sum using formula
            int sumUsingFormula = n * (n + 1) / 2;
            if (sumUsingForLoop == sumUsingFormula) {
                System.out.println("Result Verified: Both computations are correct.");
            } else {
                System.out.println("Result Mismatch: Computations are not equal.");
            }
        }

    }
}

