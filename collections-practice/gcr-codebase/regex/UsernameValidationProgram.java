import java.util.Scanner;

public class UsernameValidationProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName;
        boolean isValid;

        System.out.println("Enter username:");
        userName = scanner.nextLine();

        isValid = validateUserName(userName);

        if (isValid) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
    }

    // Method to validate username using rules
    public static boolean validateUserName(String userName) {

        // Variable to store regex pattern
        String userNamePattern;
        userNamePattern = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        return userName.matches(userNamePattern);
    }
}
