import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        return hasUpper && hasDigit;
    }

    @Test
    void testValidPasswords() {
        assertTrue(isValidPassword("Password1"));
        assertTrue(isValidPassword("Abcdefg9"));
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(isValidPassword("password"));     // no uppercase, no digit
        assertFalse(isValidPassword("Password"));     // no digit
        assertFalse(isValidPassword("pass1"));        // less than 8 characters
        assertFalse(isValidPassword(null));           // null input
    }
}
