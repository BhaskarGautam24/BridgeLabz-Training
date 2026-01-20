import java.io.File;
import java.util.*;

public class FilterCSVRecords {
    public static void main(String[] args){
        try {
            File file = new File("students.csv");
            Scanner scnn = new Scanner(file);

            if (scnn.hasNextLine()) {
                scnn.nextLine();
            }

            System.out.println("Students who scored more than 80:\n");
            while (scnn.hasNextLine()) {

                String line = scnn.nextLine();
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);
                if (marks>80) {
                    System.out.println("ID     : "+id);
                    System.out.println("Name   : "+name);
                    System.out.println("Age    : "+age);
                    System.out.println("Marks  : "+marks);
                    System.out.println("----------------------");
                }
            }

        } catch (Exception e) {
            System.out.println("Error while filtering csv file");
        }
    }
}
