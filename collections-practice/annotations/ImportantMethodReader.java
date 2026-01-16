import java.lang.annotation.*;
import java.lang.reflect.Method;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod
{

    String level() default "HIGH";
}

// Class with annotated methods
class Service
{
    @ImportantMethod
    public void processData()
    {
        System.out.println("Processing data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void generateReport()
    {
        System.out.println("Generating report...");
    }

    public void normalMethod()
    {
        System.out.println("This is normal method.");
    }
}

public class ImportantMethodReader
{
    public static void main(String[] args)
    {
        try
        {
            // get Class object
            Class classObject = Service.class;

            Method[] methodArray = classObject.getDeclaredMethods();

            for (int i = 0; i < methodArray.length; i++)
            {
                Method methodObject = methodArray[i];

                // check if method have ImportantMethod annotation
                if (methodObject.isAnnotationPresent(ImportantMethod.class))
                {
                    // get annotation object
                    ImportantMethod annotationObject =
                            methodObject.getAnnotation(ImportantMethod.class);

                    System.out.println("Important Method Found:");
                    System.out.println("Method Name: " + methodObject.getName());
                    System.out.println("Level: " + annotationObject.level());
                    System.out.println("----------------------");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occured while reading annotation.");
        }
    }
}

