import java.util.*;
public class EventWelcome {
    public static void main(String[] args) {
        List<String> attendees = new ArrayList<String>();
        attendees.add("Rahul");
        attendees.add("Amit");
        attendees.add("Neha");
        attendees.forEach(a ->
                System.out.println("Welcome " + a));
    }
}
