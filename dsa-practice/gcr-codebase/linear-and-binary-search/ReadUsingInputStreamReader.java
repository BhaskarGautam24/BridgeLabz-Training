import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
// interface for stream reading
interface StreamReader {
    // method to read file
    void readData(String filePath, String charsetName);
}

// abstract class for common work
abstract class BaseStreamReader implements StreamReader {

    // concrete method for small info
    public void showNote() {
        // simple note msg
        System.out.println("reading binary data as characters");
    }

    // abstract method
    public abstract void readData(String filePath, String charsetName);
}

// child class using inputstreamreader
class CharacterStreamReader extends BaseStreamReader {

    // private variable for file path
    private String path;

    // private variable for charset
    private String charset;

    // setter for path
    public void setPath(String path) {
        // assigning using this
        this.path = path;
    }

    // getter for path
    public String getPath() {
        // returning path
        return this.path;
    }

    // setter for charset
    public void setCharset(String charset) {
        // assigning charset value
        this.charset = charset;
    }

    // getter for charset
    public String getCharset() {
        // returning charset
        return this.charset;
    }

    // overriding read method
    @Override
    public void readData(String filePath, String charsetName) {

        // fileinputstream variable
        FileInputStream fis = null;

        // inputstreamreader variable
        InputStreamReader isr = null;

        // bufferedreader variable
        BufferedReader br = null;

        try {
            // creating file input stream
            fis = new FileInputStream(filePath);

            // converting byte stream to char stream
            isr = new InputStreamReader(fis, charsetName);

            // wrapping with bufferedreader
            br = new BufferedReader(isr);

            // variable for line
            String line;

            // loop for reading lines
            while ((line = br.readLine()) != null) {

                // printing each line
                System.out.println(line);
            }

        } catch (IOException e) {
            // error msg for read issue
            System.out.println("problem while reading file");
        } finally {
            try {
                // closing bufferedreader
                if (br != null) {
                    br.close();
                }

                // closing inputstreamreader
                if (isr != null) {
                    isr.close();
                }

                // closing fileinputstream
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                // error while closing
                System.out.println("problem while closing streams");
            }
        }
    }
}
public class ReadUsingInputStreamReader {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // asking file path
        System.out.println("enter file path");
        // storing file path
        String filePath = scn.nextLine();

        // asking charset name
        System.out.println("enter charset name like UTF-8");
        // storing charset
        String charsetName = scn.nextLine();

        // parent reference for polymorphism
        BaseStreamReader reader = new CharacterStreamReader();

        // checking object type
        if (reader instanceof CharacterStreamReader) {
            // casting to child class
            CharacterStreamReader csReader = (CharacterStreamReader) reader;

            // setting values
            csReader.setPath(filePath);
            csReader.setCharset(charsetName);
            // showing note
            csReader.showNote();
            // reading data
            csReader.readData(csReader.getPath(), csReader.getCharset());
        }
    }
}
