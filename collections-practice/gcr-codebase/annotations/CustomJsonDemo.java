import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

// Custom annotation for JSON field mapping
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField
{
    String name();
}

class User
{
    @JsonField(name = "user_id")
    private int id;

    @JsonField(name = "user_name")
    private String name;

    private int age; // not annotated, will use normal field name

    public User(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class JsonSerializer
{
    public static String toJson(Object object)
    {
        String jsonString = "{";

        try
        {

            Class classObject = object.getClass();

            // get all fields
            Field[] fieldArray = classObject.getDeclaredFields();

            for (int i = 0; i < fieldArray.length; i++)
            {
                Field fieldObject = fieldArray[i];
                fieldObject.setAccessible(true);

                String jsonKey;

                // check if field have JsonField annotation
                if (fieldObject.isAnnotationPresent(JsonField.class))
                {
                    JsonField annotationObject =
                            fieldObject.getAnnotation(JsonField.class);

                    jsonKey = annotationObject.name();
                }
                else
                {
                    jsonKey = fieldObject.getName();
                }

                Object fieldValue = fieldObject.get(object);

                // build json string
                jsonString = jsonString + "\"" + jsonKey + "\": ";

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
            System.out.println("Error occured during json serialization.");
        }

        return jsonString;
    }
}

public class CustomJsonDemo
{
    public static void main(String[] args)
    {
        // create user object
        User userObject = new User(101, "Rohit", 22);

        String jsonOutput = JsonSerializer.toJson(userObject);

        System.out.println("JSON Output:");
        System.out.println(jsonOutput);
    }
}
