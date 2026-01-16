import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            divide(10, 0);
        });
    }
}

