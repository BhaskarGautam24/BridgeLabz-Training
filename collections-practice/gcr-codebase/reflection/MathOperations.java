import java.lang.reflect.Method;
import java.util.*;
public class MathOperations
{
    public int add(int a, int b)
    {
        return a + b;
    }

    public int subtract(int a, int b)
    {
        return a - b;
    }

    public int multiply(int a, int b)
    {
        return a * b;
    }
}

class DynamicMethodInvoke
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        try
        {
            // Create object of MathOperations
            MathOperations mathObject = new MathOperations();

            // Get Class object
            Class classObject = mathObject.getClass();

            System.out.println("Enter method name (add / subtract / multiply):");
            String methodName = sc.nextLine();

            System.out.println("Enter first number:");
            int num1 = sc.nextInt();

            System.out.println("Enter second number:");
            int num2 = sc.nextInt();

            // Get method dynamically
            Method methodObject = classObject.getMethod(methodName, int.class, int.class);

            Object result = methodObject.invoke(mathObject, num1, num2);   // invoke method

            System.out.println("Result is: " + result);
        }
        catch (Exception e)
        {
            System.out.println("Invalid method name or error occured during execution.");
        }

    }
}
