import java.util.function.Function;
public class StringLengthChecker {
    public static void main(String[] args){
        String message = "Functional interfaces are very important in Java";
        int limit = 30;
        Function<String, Integer> lengthFinder = msg -> msg.length();
        int length = lengthFinder.apply(message);
        if (length > limit){
            System.out.println("Message length exceeded the limit");
        } else {
            System.out.println("Message length is within limit");
        }
    }
}

