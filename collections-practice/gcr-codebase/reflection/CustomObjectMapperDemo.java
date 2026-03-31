import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
class Student
{
    private int id;
    private String name;
    private int marks;
}

class ObjectMapper
{
    // Generic method to convert Map to Object
    public static <T> T toObject(Class<T> classType, Map<String, Object> propertyMap)
    {
        T object = null;

        try
        {
          
            object = classType.getDeclaredConstructor().newInstance();    // create object of class 

            // Get all fields of class
            Field[] fieldArray = classType.getDeclaredFields();

            for (int i = 0; i < fieldArray.length; i++)
            {
                Field fieldObject = fieldArray[i];

                // Make private field accessible
                fieldObject.setAccessible(true);

                // Get field name
                String fieldName = fieldObject.getName();

                // Check if map contains field name
                if (propertyMap.containsKey(fieldName))
                {
                    // Set value to field
                    fieldObject.set(object, propertyMap.get(fieldName));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occured while mapping object.");
        }

        return object;
    }
}

public class CustomObjectMapperDemo
{
    public static void main(String[] args)
    {
        // Create Map with data
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("id", 101);
        dataMap.put("name", "Rahul");
        dataMap.put("marks", 85);

        // Convert Map to Student object
        Student studentObject = ObjectMapper.toObject(Student.class, dataMap);
        try
        {
            Field[] fields = studentObject.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++)
            {
                fields[i].setAccessible(true);
                System.out.println(fields[i].getName() + " = " + fields[i].get(studentObject));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while displaying object data.");
        }
    }
}
