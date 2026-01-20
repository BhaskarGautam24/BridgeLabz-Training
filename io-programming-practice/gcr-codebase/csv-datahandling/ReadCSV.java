import java.io.*;
import java.util.*;

public class ReadCSV {

    public static void main(String[] args) {
        try {
            File fl = new File(" students.csv ");
            Scanner scnn=new Scanner(fl);

            // Skip header line
            if (scnn.hasNextLine()) {
                scnn.nextLine();
            }

            System.out.println(" Student Details: ");
            while (scnn.hasNextLine()) {
                String line = scnn.nextLine();
                String[] content = line. split(",");

                int id = Integer.parseInt(content[0]);
                String name = content[1];
                int age = Integer.parseInt(content[2]);
                int marks = Integer.parseInt(content[3]);

                System.out.println("ID   : " + id);
                System.out.println("Name : " + name);
                System.out.println("Age  : " + age);
                System.out.println("Marks : " + marks);
                System.out.println("---------------");
            }


        } catch (Exception e) {
            System.out.println("Error while reading");
        }
    }
}
