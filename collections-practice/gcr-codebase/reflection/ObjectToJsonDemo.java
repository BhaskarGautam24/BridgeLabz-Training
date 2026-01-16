import java.lang.reflect.Field;

class Employee
{
    private int id;
    private String name;
    private double salary;

    // Constructor to set values
    public Employee(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

// Utility class to convert object to JSON-like string
class JsonConverter
{
    public static String toJson(Object object)
    {
        String jsonString = "{";

        try
        {
            // Get class of object
            Class classObject = object.getClass();

            // Get all fields of class
            Field[] fieldArray = classObject.getDeclaredFields();

            for (int i = 0; i < fieldArray.length; i++)
            {
                Field fieldObject = fieldArray[i];

                // allow access to private field
                fieldObject.setAccessible(true);

                // get field name and value
                String fieldName = fieldObject.getName();
                Object fieldValue = fieldObject.get(object);

                // add field to json string
                jsonString = jsonString + "\"" + fieldName + "\": ";

                if (fieldValue instanceof String)
                {
                    jsonString = jsonString + "\"" + fieldValue + "\"";
                }
                else
                {
                    jsonString = jsonString + fieldValue;
                }

                if (i < fieldArray.length - 1)
                {
                    jsonString = jsonString + ", ";
                }
            }

            jsonString = jsonString + "}";
        }
        catch (Exception e)
        {
            System.out.println("Error occured while converting object to json.");
        }

        return jsonString;
    }
}

public class ObjectToJsonDemo
{
    public static void main(String[] args)
    {
        // create employee object
        Employee empObject = new Employee(101, "Amit", 45000.50);

        // convert object to json-like string
        String jsonOutput = JsonConverter.toJson(empObject);

        System.out.println("JSON Representation:");
        System.out.println(jsonOutput);
    }
}

