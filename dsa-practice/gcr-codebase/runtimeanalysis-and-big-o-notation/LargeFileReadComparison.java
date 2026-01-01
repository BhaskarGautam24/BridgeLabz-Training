import java.io.*;
import java.util.*;
interface ReadTime {                    // interface for reading time
    void readFile(String filePath);
}
abstract class FileReadBase {
    private String readerName;
    FileReadBase(String readerName) {
        this.readerName = readerName;
    }
    public String getReaderName() {
        return this.readerName;
    }

    // abstract read method
    abstract void read(String filePath) throws IOException;

    // concrete method
    void showReader() {
        System.out.println("\nusing " + readerName);
    }
}

// filereader class
class FileReaderTest extends FileReadBase implements ReadTime {
    FileReaderTest() {
        super("file reader");
    }
    void read(String filePath) throws IOException {

        // reader object
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1) {
            // just reading chars
        }

        fr.close();
    }

    // time check
    public void readFile(String filePath) {

        try {
            long start = System.currentTimeMillis();
            read(filePath);
            long end = System.currentTimeMillis();
            System.out.println("time : " + (end - start) + " ms");
        } catch (IOException e) {
            System.out.println("file issue happen");
        }
    }
}
class InputStreamReaderTest extends FileReadBase implements ReadTime {
    InputStreamReaderTest() {
        super("input stream reader");
    }
    void read(String filePath) throws IOException {

        // reader object
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));

        while (isr.read() != -1) {
            // reading bytes to char
        }
    }

    public void readFile(String filePath) {

        try {
            long start = System.currentTimeMillis();
            read(filePath);
            long end = System.currentTimeMillis();
            System.out.println("time : " + (end - start) + " ms");
        } catch (IOException e) {
            System.out.println("file issue happen");
        }
    }
}

public class LargeFileReadComparison {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter file path : ");
        String path = scn.nextLine();

        // parent reference
        FileReadBase reader;

        // filereader test
        reader = new FileReaderTest();
        reader.showReader();
        if (reader instanceof ReadTime) {
            ((ReadTime) reader).readFile(path);
        }

        // inputstreamreader test
        reader = new InputStreamReaderTest();
        reader.showReader();
        if (reader instanceof ReadTime) {
            ((ReadTime) reader).readFile(path);
        }

    }
}


