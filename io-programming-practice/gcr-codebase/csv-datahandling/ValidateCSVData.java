import java.io.File;
import java.util.*;
public class ValidateCSVData {
    public static void main(String[] args) {

        try {
            File fl=new File("users.csv");
            Scanner scnn=new Scanner(fl);

            // Regex for email validation
            String emailRegex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            // Skiping header line
            if (scnn.hasNextLine()) {
                scnn.nextLine();
            }
            System.out.println("Invalid Records Found:\n");

            // Reading each row from csv file
            while (scnn.hasNextLine()) {

                String ln=scnn.nextLine();
                String[] data=ln.split(",");

                int id=Integer.parseInt(data[0]);
                String name=data[1];
                String email=data[2];
                String phone=data[3];

                boolean isValid=true;

                // Checking email format
                if (!email.matches(emailRegex)) {
                    System.out.println("Invalid Email for ID " + id + " : " + email);
                    isValid=false;
                }

                // Checking phone number length
                if (phone.length()!= 10) {
                    System.out.println("Invalid Phone Number for ID " + id + " : " + phone);
                    isValid=false;
                }
                if (isValid == false) {
                    System.out.println("Row Data -> " + ln);
                    System.out.println("----------------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("Error occured while validating csv data");
        }
    }
}
