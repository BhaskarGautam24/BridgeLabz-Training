import java.io.File;
import java.util.Scanner;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        try {
            File file=new File("students.csv");
            Scanner sc=new Scanner(file);
            String[] storedIds=new String[100];
            int index = 0;
            // Skiping header line
            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            System.out.println("Duplicate Records Found:\n");

            while (sc.hasNextLine()) {

                String line=sc.nextLine();
                String[] data=line.split(",");

                String currentId=data[0];
                boolean isDuplicate=false;

                for (int i=0;i<index;i++) {
                    if (storedIds[i].equals(currentId)) {
                        isDuplicate=true;
                        break;
                    }
                }

                if (isDuplicate==true) {
                    System.out.println("Duplicate Row->"+line);
                } else {
                    storedIds[index]=currentId;
                    index++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured while detecting duplicates");
        }
    }
}
