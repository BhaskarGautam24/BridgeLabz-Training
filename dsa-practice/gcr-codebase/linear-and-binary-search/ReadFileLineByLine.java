import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
// interface for file reading
interface FileLineReader {

    // method to read file
    void readFile(String filePath);
}
// abstract class for common behavior
abstract class BaseFileReader implements FileLineReader {

    // concrete method for info
    public void showMessage() {
        // small info msg
        System.out.println("reading file line by line");
    }

    // abstract method
    public abstract void readFile(String filePath);
}

// child class using filereader
class TextFileReader extends BaseFileReader {

    // private variable for path
    private String path;

    // setter method
    public void setPath(String path) {
        // assigning value using this
        this.path = path;
    }

    // getter method
    public String getPath() {
        // returning file path
        return this.path;
    }

    // overriding read method
    @Override
    public void readFile(String filePath) {

        // filereader variable
        FileReader fr = null;

        // bufferedreader variable
        BufferedReader br = null;

        try {
            // creating filereader
            fr = new FileReader(filePath);

            // wrapping with bufferedreader
            br = new BufferedReader(fr);

            // variable for line
            String line;

            // loop for reading lines
            while ((line = br.readLine()) != null) {

                // printing each line
                System.out.println(line);
            }

        } catch (IOException e) {
            // error msg if file issue
            System.out.println("some problem while reading file");
        } finally {
            try {
                // closing bufferedreader
                if (br != null) {
                }

                // closing filereader
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                // close error msg
                System.out.println("error while closing file");
            }
        }
    }
}
public class ReadFileLineByLine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // asking file path
        System.out.println("enter file path");

        // storing path
        String filePath = scn.nextLine();

        // parent reference for polymorphism
        BaseFileReader reader = new TextFileReader();

        // checking instance type
        if (reader instanceof TextFileReader) {
            // casting to child class
            TextFileReader textReader = (TextFileReader) reader;
            // setting file path
            textReader.setPath(filePath);

            // showing message
            textReader.showMessage();

            // reading file
            textReader.readFile(textReader.getPath());
        }
    }
}

