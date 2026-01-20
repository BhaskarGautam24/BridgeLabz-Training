import java.io.File;
import java.io.FileWriter;
import java.util.*;
public class MergeCSV {
    public static void main(String[] args) {
        try {
           File file1 = new File("students1.csv");
            Scanner sc1 = new Scanner(file1);
            File file2=new File("students2.csv");
            Scanner sc2=new Scanner(file2);
            // Creating merged csv file
            FileWriter writer = new FileWriter("students_merged.csv");
            // Writing header in merged file
            writer.write("ID,Name,Age,Marks,Grade\n");

            if (sc1.hasNextLine()) sc1.nextLine();
            if (sc2.hasNextLine()) sc2.nextLine();

            String[] id2 = new String[100];
            String[] marks = new String[100];
            String[] grade = new String[100];

            int count = 0;
            while (sc2.hasNextLine()) {
                String line2 = sc2.nextLine();
                String[] data2 = line2.split(",");

                id2[count] = data2[0];
                marks[count] = data2[1];
                grade[count] = data2[2];
                count++;
            }

            while (sc1.hasNextLine()) {

                String line1 = sc1.nextLine();
                String[] data1 = line1.split(",");

                String id1 = data1[0];
                String name = data1[1];
                String age = data1[2];

                for (int i = 0; i < count; i++) {
                    if (id1.equals(id2[i])) {         
                        writer.write(id1 + "," + name + "," + age + "," + marks[i] + "," + grade[i] + "\n");
                        break;
                    }
                }
            }


            System.out.println("CSV files merged successfully");
        } catch (Exception e) {
            System.out.println("Error occured while merging csv files");
        }
    }
}
