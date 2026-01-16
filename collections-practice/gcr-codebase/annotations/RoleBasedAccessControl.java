import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

// Custom annotation for role checking
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed
{
    String value();
}

// Service class with restricted method
class AdminService
{
    @RoleAllowed("ADMIN")
    public void deleteUser()
    {
        System.out.println("User deleted successfully.");
    }

    public void viewUser()
    {
        System.out.println("Viewing user details.");
    }
}

public class RoleBasedAccessControl
{
    public static void main(String[] args)
    {
        try
        {
            String currentUserRole = "USER";     // change to ADMIN to allow access

            // create service object
            AdminService serviceObject = new AdminService();

            Class classObject = serviceObject.getClass();

            Method[] methodArray = classObject.getDeclaredMethods();

            for (int i = 0; i < methodArray.length; i++)
            {
                Method methodObject = methodArray[i];

                // check if method have RoleAllowed annotation
                if (methodObject.isAnnotationPresent(RoleAllowed.class))
                {
                    RoleAllowed roleAnnotation =
                            methodObject.getAnnotation(RoleAllowed.class);

                    // check role access
                    if (currentUserRole.equals(roleAnnotation.value()))
                    {
                        // role matched, invoke method
                        methodObject.invoke(serviceObject);
                    }
                    else
                    {

                        System.out.println("Access Denied!");
                    }
                }
                else
                {

                    methodObject.invoke(serviceObject);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occured during role validation.");
        }
    }
}

