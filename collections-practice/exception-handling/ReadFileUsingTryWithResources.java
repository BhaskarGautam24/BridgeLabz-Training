import java.io.*;
public class ReadFileUsingTryWithResources {
    public static void main(String[] args) {
        String fileName = "info.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String firstLine = bufferedReader.readLine();

            System.out.println(firstLine);
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
