import java.util.*;
public class LicensePlateValidationProgram {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        String licensePlate;

        boolean isValid;

        System.out.println("Enter license plate number:");
        licensePlate = scn.nextLine();

        isValid = validateLicensePlate(licensePlate);

        if (isValid) {
            System.out.println("Valid License Plate Number");
        } else {
            System.out.println("Invalid License Plate Number");
        }

    }

    public static boolean validateLicensePlate(String licensePlate) {

        String licensePlatePattern;

        licensePlatePattern = "^[A-Z]{2}[0-9]{4}$";

        return licensePlate.matches(licensePlatePattern);
    }
}

