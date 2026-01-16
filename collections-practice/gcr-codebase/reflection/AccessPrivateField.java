import java.lang.reflect.Field;
import java.util.*;

class Person
{

    private int age;
}

public class AccessPrivateField
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        try
        {
            // Create object of Person class
            Person personObject = new Person();

            // Get Class object
            Class classObject = personObject.getClass();

            Field ageField = classObject.getDeclaredField("age");

            ageField.setAccessible(true);

            System.out.println("Enter age to set:");
            int userAge = sc.nextInt();

            // Set value to private field
            ageField.set(personObject, userAge);

            // Get value from private field
            int retrievedAge = (int) ageField.get(personObject);

            System.out.println("Age value after modification: " + retrievedAge);
        }
        catch (Exception e)
        {
            System.out.println("Some error occured while accessing private field.");
        }
    }
}

