import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberTest {

    // Method to check even number
    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Parameterized test
    @ParameterizedTest
    @ValueSource(ints = {2,4,7,8,9})
    void testIsEven(int number) {
        if (number % 2 == 0) {
            assertTrue(isEven(number));
        } else {
            assertFalse(isEven(number));
        }
    }
}
