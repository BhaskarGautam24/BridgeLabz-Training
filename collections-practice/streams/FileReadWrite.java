import java.io.*;
import java.util.*;
public class FileReadWrite {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter source file name: ");
        String sourceFile = scn.nextLine();

        System.out.print("Enter destination file name: ");
        String destinationFile = scn.nextLine();

        FileInputStream fileinputsystem = null;
        FileOutputStream fileoutputsystem = null;

        try {
            // FileInputStream used to read data from file
            fileinputsystem = new FileInputStream(sourceFile);

            // FileOutputStream create file if not exist
            fileoutputsystem = new FileOutputStream(destinationFile);
            int data;

            // read one byte at a time and write into new file
            while ((data = fileinputsystem.read()) != -1) {
                fileoutputsystem.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error: Source file not exist or problem in reading file.");
        } finally {
            try {
                if (fileinputsystem != null) {
                    fileinputsystem.close();
                }
                if (fileoutputsystem != null) {
                    fileoutputsystem.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing file.");
            }
        }
    }
}


