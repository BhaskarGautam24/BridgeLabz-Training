import java.util.InputMismatchException;
import java.util.*;
public class DivisionWithUncheckedException {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);

        int firstNumber = 0;

        int secondNumber = 0;

        int divisionResult = 0;

        try {

            System.out.println("Enter first number:");
            firstNumber = scannerObject.nextInt();

            System.out.println("Enter second number:");
            secondNumber = scannerObject.nextInt();

            divisionResult = firstNumber / secondNumber;

            System.out.println("Division result is: " + divisionResult);
        }
        catch (ArithmeticException arithmeticExceptionObject) {

            System.out.println("Error: Division by zero is not allow.");
        }
        catch (InputMismatchException inputMismatchExceptionObject) {

            System.out.println("Error: Please enter only numeric value.");
        }
        finally {
            System.out.println("Program execution finished.");
        }
    }
}
