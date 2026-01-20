import java.io.File;
import java.util.*;

public class SearchEmployeeCSV {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        try {
            // Taking employee name from user
            System.out.print(" Enter employee name to search: " );
            String searchName=input.nextLine();

            // Opening employee csv file
            File file=new File("employees.csv");
            Scanner sc=new Scanner(file);

            // Skiping header line
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            boolean found=false;

            // Reading each employee record
            while (sc.hasNextLine()) {

                String line=sc.nextLine();
                String[] data=line.split(",");

                String name=data[1];
                String department=data[2];
                int salary=Integer.parseInt(data[3]);

                // Checking name is matching or not
                if (name.equalsIgnoreCase(searchName)) {

                    System.out.println("\nEmployee Found:");
                    System.out.println("Name       : " + name);
                    System.out.println("Department : " + department);
                    System.out.println("Salary     : " + salary);

                    found=true;
                    break; // Record found so stop reading
                }
            }

            if (found==false) {
                System.out.println("Employee not found in csv file");
            }


        } catch (Exception e) {
            System.out.println("Error while searching employee record");
        }
    }
}
