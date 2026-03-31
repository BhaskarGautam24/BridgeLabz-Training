import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime
{
    // no parameter needed
}

class TaskService
{
    @LogExecutionTime
    public void fastTask()
    {
        for (int i = 0; i < 1000; i++)
        {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void slowTask()
    {
        for (int i = 0; i < 1000000; i++)
        {
            int y = i + i;
        }
    }

    public void normalTask()
    {
        System.out.println("This task is not logged.");
    }
}

public class ExecutionTimeLogger
{
    public static void main(String[] args)
    {
        try
        {
            // create object
            TaskService serviceObject = new TaskService();

            // get class object
            Class classObject = serviceObject.getClass();

            // get all methods
            Method[] methodArray = classObject.getDeclaredMethods();
            for (int i = 0; i < methodArray.length; i++)
            {
                Method methodObject = methodArray[i];

                if (methodObject.isAnnotationPresent(LogExecutionTime.class))
                {
                    // record start time
                    long startTime = System.nanoTime();

                    methodObject.invoke(serviceObject);

                    // record end time
                    long endTime = System.nanoTime();

                    // calculate execution time
                    long executionTime = endTime - startTime;

                    System.out.println("Method Name: " + methodObject.getName());
                    System.out.println("Execution Time (nano seconds): " + executionTime);
                    System.out.println("-------------------------------");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occured while measuring execution time.");
        }
    }
}

