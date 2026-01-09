import java.io.FileInputStream;
import java.io.IOException;
public class ReadTextFileCheckedException {
    public static void main(String[] args) {
        String fileName = "data.txt";
        FileInputStream fileInputStream = null;
        try {

            fileInputStream = new FileInputStream(fileName);

            int fileData = 0;

            // reading file content byte by byte
            while ((fileData = fileInputStream.read()) != -1) {

                System.out.print((char) fileData);
            }

        } catch (IOException exception) {

            System.out.println("File not found");

        } finally {

            try {

                if (fileInputStream != null) {
                    fileInputStream.close();
                }

            } catch (IOException exception) {

                System.out.println("Error while closing file");
            }
        }
    }
}
