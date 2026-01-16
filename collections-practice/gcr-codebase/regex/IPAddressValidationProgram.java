import java.util.*;
public class IPAddressValidationProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipAddress;

        boolean isValid;

        System.out.println("Enter IP address:");
        ipAddress = sc.nextLine();

        isValid = validateIPAddress(ipAddress);

        if (isValid) {
            System.out.println("Valid IP Address");
        } else {
            System.out.println("Invalid IP Address");
        }
    }

    // Method to validate IPv4 address
    public static boolean validateIPAddress(String ipAddress) {

        String ipPattern;

        ipPattern = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}"
                  + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        // Returning match result
        return ipAddress.matches(ipPattern);
    }
}

