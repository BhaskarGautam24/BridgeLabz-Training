import java.lang.reflect.*;
import java.util.*;

public class ClassInformation
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the class name (example: java.util.Scanner):");
        String className = sc.nextLine();

        try
        {
            // Load class using reflection
            Class classObj = Class.forName(className);

            System.out.println("\nClass Name: " + classObj.getName());

            System.out.println("\nMethods in the class:");
            Method[] methodArray = classObj.getDeclaredMethods();

            for (int i = 0; i < methodArray.length; i++)
            {
                System.out.println(methodArray[i].getName());
            }

            System.out.println("\nFields in the class:");
            Field[] fieldArray = classObj.getDeclaredFields();

            for (int i = 0; i < fieldArray.length; i++)
            {
                System.out.println(fieldArray[i].getName());
            }

            System.out.println("\nConstructors in the class:");
            Constructor[] constructorArray = classObj.getDeclaredConstructors();

            for (int i=0; i<constructorArray.length; i++)
            {
                System.out.println(constructorArray[i].getName ());
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found. Please enter correct class name.");
        }

    }
}

