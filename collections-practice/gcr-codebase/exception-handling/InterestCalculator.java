public class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years)
            throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {

            throw new IllegalArgumentException("Invalid input");
        }

        double interest;

        interest = (amount * rate * years) / 100;

        return interest;
    }

    public static void main(String[] args) {

        double amount = 5000;
        double rate = 5;
        int years = 2;

        try {
            double result = calculateInterest(amount, rate, years);

            System.out.println("Calculated Interest: " + result);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
