import java.io.*;
public class UserInputToFile {
    public static void main(String[] args) {
        BufferedReader br = null;
        FileWriter fw = null;
        try {
            // BufferedReader use for taking input from console
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();
            String language = br.readLine();

            fw = new FileWriter("user_details.txt");

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("User information saved successfully.");

        } catch (IOException e) {
            // exception handle if input or file error happen
            System.out.println("Error while reading input or writing file.");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing resources.");
            }
        }
    }
}

