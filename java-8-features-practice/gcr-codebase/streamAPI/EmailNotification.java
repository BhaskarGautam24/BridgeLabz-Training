import java.util.*;
public class EmailNotification{
    public static void main(String[] args){
        List<String> emails = new ArrayList<String>();
        emails.add("a@gmail.com");
        emails.add("b@gmail.com");
        emails.forEach(e -> sendEmailNotification(e));
    }
    static void sendEmailNotification(String email){
        System.out.println("Mail sent to " + email);
    }
}

