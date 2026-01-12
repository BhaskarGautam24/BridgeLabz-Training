// Import JUnit 5 classes
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Calculator {

    // Method to add two numbers
    public int add(int a, int b) {
        int result;
        result = a + b;
        return result;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        int result;
        result = a - b;
        return result;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        int result;
        result = a * b;
        return result;
    }

    // Method to divide two numbers
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        int result;
        result = a / b;
        return result;
    }
}

// JUnit test class for Calculator
class CalculatorTest {

    Calculator calculator = new Calculator();

    // Test for add method
    @Test
    void testAdd() {
        int result = calculator.add(10, 5);
        assertEquals(15, result);
    }

    // Test for subtract method
    @Test
    void testSubtract() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
    }

    // Test for multiply method
    @Test
    void testMultiply() {
        int result = calculator.multiply(4, 5);
        assertEquals(20, result);
    }

    // Test for divide method
    @Test
    void testDivide() {
        int result = calculator.divide(20, 5);
        assertEquals(4, result);
    }
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
