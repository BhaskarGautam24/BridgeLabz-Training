import java.util.*;
interface LightAction{
    void activate();
}
public class SmartHomeLighting{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose trigger:");
        System.out.println("1. Motion");
        System.out.println("2. Night Time");
        System.out.println("3. Voice Command");
        int choice = sc.nextInt();
        // one lambda reference used only once
        LightAction lightAction = () ->{
            if (choice == 1) {
                System.out.println("Lights ON at full brightness due to motion detect");
            } else if (choice == 2) {
                System.out.println("Lights ON in dim mode because its night time");
            } else if (choice == 3) {
                System.out.println("Lights ON as per voice command");
            } else {
                System.out.println("Invalid trigger selected");
            }
        };
        lightAction.activate();

    }
}
