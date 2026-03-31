import java.util.*;
public class CreditCardValidationProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String cardNumber;

        boolean isValid;

        System.out.println("Enter credit card number:");
        cardNumber = sc.nextLine();

        isValid = validateCardNumber(cardNumber);

        if (isValid) {
            System.out.println("Valid Credit Card Number");
        } else {
            System.out.println("Invalid Credit Card Number");
        }

    }

    // Method to validate Visa and MasterCard numbers
    public static boolean validateCardNumber(String cardNumber) {
        String cardPattern;

        cardPattern = "^(4[0-9]{15}|5[0-9]{15})$";

        // Returning matching result
        return cardNumber.matches(cardPattern);
    }
}

