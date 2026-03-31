import java.lang.reflect.*;
interface Greeting
{
    void sayHello();
}

// Actual implementation class
class GreetingImpl implements Greeting
{
    public void sayHello()
    {
        System.out.println("Hello, welcome to Java Reflection!");
    }
}

class LoggingHandler implements InvocationHandler
{
    private Object targetObject;

    // constructor to set target object
    public LoggingHandler(Object targetObject)
    {
        this.targetObject = targetObject;
    }

    // this method intercept method call
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("Method called: " + method.getName());

        Object result = method.invoke(targetObject, args);

        return result;
    }
}

public class DynamicProxyDemo
{
    public static void main(String[] args)
    {
        Greeting greetingObject = new GreetingImpl();

        // create proxy object
        Greeting proxyObject = (Greeting) Proxy.newProxyInstance(
                greetingObject.getClass().getClassLoader(),
                greetingObject.getClass().getInterfaces(),
                new LoggingHandler(greetingObject)
        );

        proxyObject.sayHello();
    }
}
