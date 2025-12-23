import java.util.*;
public class OTPGenerator {
    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;       // Ensures a 6-digit number
    }

    // Method to check if an array has all unique numbers
    public static boolean areUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false; // Found a duplicate
                }
            }
        }
        return true; // All numbers are unique
    }

    // Main method to generate 10 OTPs and validate uniqueness
    public static void main(String[] args) {
        int[] otpArray = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        // Display the generated OTPs
        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));

        // Check if all OTPs are unique
        if (areUnique(otpArray)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Some OTPs are not unique.");
        }
    }
}

