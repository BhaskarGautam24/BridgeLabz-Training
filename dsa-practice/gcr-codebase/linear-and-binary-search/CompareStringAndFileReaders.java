import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
// interface for string test
interface StringTest {
    // method for test
    long runTest(String text, int times);
}
// interface for file test
interface FileTest {
    // method to count words
    long countWords(String path);
}
// abstract class for string logic
abstract class BaseStringTest implements StringTest {

    // concrete method for info
    public void showStringInfo() {
        // small info msg
        System.out.println("running string concatenation test");
    }
    // abstract method
    public abstract long runTest(String text, int times);
}
// abstract class for file logic
abstract class BaseFileTest implements FileTest {
    // concrete method for info
    public void showFileInfo() {
        // small info msg
        System.out.println("running file read and word count");
    }
    // abstract method
    public abstract long countWords(String path);
}
// class using stringbuilder
class BuilderTest extends BaseStringTest {
    // overriding method
    @Override
    public long runTest(String text, int times) {

        // start time variable
        long startTime = System.currentTimeMillis();

        // stringbuilder object
        StringBuilder sb = new StringBuilder();

        // loop for concat
        for (int i = 0; i < times; i++) {
            sb.append(text);
        }

        // end time variable
        long endTime = System.currentTimeMillis();

        // returning time taken
        return endTime - startTime;
    }
}

// class using stringbuffer
class BufferTest extends BaseStringTest {

    // overriding method
    @Override
    public long runTest(String text, int times) {

        // start time variable
        long startTime = System.currentTimeMillis();

        // stringbuffer object
        StringBuffer sb = new StringBuffer();

        // loop for concat
        for (int i = 0; i < times; i++) {
            sb.append(text);
        }

        // end time variable
        long endTime = System.currentTimeMillis();

        // returning time taken
        return endTime - startTime;
    }
}

// class using filereader
class FileReaderTest extends BaseFileTest {

    // overriding method
    @Override
    public long countWords(String path) {

        // start time
        long startTime = System.currentTimeMillis();

        // word count variable
        long wordCount = 0;

        // reader objects
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // creating reader
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            // line variable
            String line;

            // loop for reading
            while ((line = br.readLine()) != null) {

                // splitting words
                String[] words = line.split("\\s+");

                // adding count
                wordCount = wordCount + words.length;
            }

        } catch (IOException e) {
            // error msg
            System.out.println("problem reading file with filereader");
        } finally {
            try {
                // closing reader
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {

                System.out.println("error while closing filereader");
            }
        }

        // end time
        long endTime = System.currentTimeMillis();

        // printing word count
        System.out.println("words counted using filereader: " + wordCount);

        // returning time taken
        return endTime - startTime;
    }
}

// class using inputstreamreader
class InputStreamReaderTest extends BaseFileTest {

    // overriding method
    @Override
    public long countWords(String path) {

        // start time
        long startTime = System.currentTimeMillis();

        // word count variable
        long wordCount = 0;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            // creating streams
            fis = new FileInputStream(path);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);

            // line variable
            String line;
            while ((line = br.readLine()) != null) {

                // splitting words
                String[] words = line.split("\\s+");

                // adding count
                wordCount = wordCount + words.length;
            }

        } catch (IOException e) {
            System.out.println("problem reading file with inputstreamreader");
        } finally {
            try {
                // closing streams
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("error while closing streams");
            }
        }
        long endTime = System.currentTimeMillis();

        // printing word count
        System.out.println("words counted using inputstreamreader: " + wordCount);

        // returning time taken
        return endTime - startTime;
    }
}
public class CompareStringAndFileReaders {

    // constant value for loop
    static final int TIMES = 1000000;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // fixed text variable
        String text = "hello";
        // parent reference for string tests
        BaseStringTest builderTest = new BuilderTest();
        BaseStringTest bufferTest = new BufferTest();
        // showing info
        builderTest.showStringInfo();
        long builderTime = builderTest.runTest(text, TIMES);
        // running buffer test
        long bufferTime = bufferTest.runTest(text, TIMES);
        // printing results
        System.out.println("stringbuilder time taken: " + builderTime + " ms");
        System.out.println("stringbuffer time taken: " + bufferTime + " ms");
        // asking file path
        System.out.println("enter large file path");
        // storing path
        String filePath = scn.nextLine();
        // parent reference for file tests
        BaseFileTest frTest = new FileReaderTest();
        BaseFileTest isrTest = new InputStreamReaderTest();
        frTest.showFileInfo();

        // running filereader test
        long frTime = frTest.countWords(filePath);

        // running inputstreamreader test
        long isrTime = isrTest.countWords(filePath);
        // printing time results
        System.out.println("filereader time taken: " + frTime + " ms");
        System.out.println("inputstreamreader time taken: " + isrTime + " ms");
    }
}

