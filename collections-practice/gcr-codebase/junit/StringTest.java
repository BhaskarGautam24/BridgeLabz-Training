import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {
    static String reverse(String st) {
        String rev = "";
        for (int i = st.length() - 1; i >= 0; i--) {
            rev = rev + st.charAt(i);
        }
        return rev;
    }

    static boolean isPalindrome(String st) {
        String reversed = reverse(st);
        return st.equalsIgnoreCase(reversed);
    }

    // Method to convert string to uppercase
    static String toUpperCase(String st) {
        return st.toUpperCase();
    }

    @Test
    void testReverse() {
        assertEquals("olleh", reverse("hello"));
        assertEquals("avaj", reverse("java"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(isPalindrome("madam"));
        assertTrue(isPalindrome("RaceCar"));
        assertFalse(isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", toUpperCase("hello"));
        assertEquals("JAVA", toUpperCase("java"));
    }
}
