import java.util.Scanner;

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidationSystem {

    public static void validateAge(int ageValue) throws InvalidAgeException {

        if (ageValue < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);

        int userAge = 0;

        try {
            System.out.println("Enter your age:");
            userAge = scannerObject.nextInt();

            validateAge(userAge);

            System.out.println("Access granted!");
        }
        catch (InvalidAgeException invalidAgeExceptionObject) {
            // handling custom age exception
            System.out.println(invalidAgeExceptionObject.getMessage());
        }
    }
}

