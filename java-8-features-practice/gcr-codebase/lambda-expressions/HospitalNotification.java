import java.util.ArrayList;
import java.util.*;
import java.util.function.Predicate;
class Alert{
    String message;
    String type; 

    Alert(String message, String type){
        this.message = message;
        this.type = type;
    }
}
public class HospitalNotification{
    public static void main(String[] args){
        ArrayList<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("Heart rate critical", "EMERGENCY"));
        alerts.add(new Alert("Time to take medicine", "MEDICINE"));
        alerts.add(new Alert("Blood report ready", "REPORT"));
        alerts.add(new Alert("BP level high", "EMERGENCY"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose alert preference:");
        System.out.println("1. Emergency Alerts");
        System.out.println("2. Medicine Alerts");
        System.out.println("3. Report Alerts");

        int choice = sc.nextInt();
        Predicate<Alert> filterAlert = alert ->{

            if (choice == 1){
                return alert.type.equals("EMERGENCY");
            } else if (choice == 2){
                return alert.type.equals("MEDICINE");
            } else if (choice == 3){
                return alert.type.equals("REPORT");
            } else{
                return false;
            }
        };

        System.out.println("\nFiltered Alerts:");
        for (Alert a : alerts){
            if (filterAlert.test(a)){
                System.out.println(a.message + " (" + a.type + ")");
            }
        }
    }
}
