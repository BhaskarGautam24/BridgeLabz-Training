import java.io.*;
import java.util.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source file name: ");
        String sourceFile = sc.nextLine();
        String normalDest = sc.nextLine();
        String bufferedDest = sc.nextLine();

        // calling normal stream copy
        long normalTime = copyUsingNormalStream(sourceFile, normalDest);

        // calling buffered stream copy
        long bufferedTime = copyUsingBufferedStream(sourceFile, bufferedDest);

        System.out.println("\nExecution Time Comparison:");
        System.out.println("Normal Stream Time   : " + normalTime + " ns");
        System.out.println("Buffered Stream Time : " + bufferedTime + " ns");
    }

    // method for copying file using FileInputStream and FileOutputStream
    public static long copyUsingNormalStream(String source, String dest) {

        FileInputStream fileInputSystem = null;
        FileOutputStream fileOutputSystem = null;

        byte[] buffer = new byte[4096]; // 4KB chunk
        int bytesRead;

        long startTime = 0;
        long endTime = 0;

        try {
            fileInputSystem = new FileInputStream(source);
            fileOutputSystem = new FileOutputStream(dest);

            startTime = System.nanoTime();

            // reading and writing data in chunks
            while ((bytesRead = fileInputSystem.read(buffer)) != -1) {
                fileOutputSystem.write(buffer, 0, bytesRead);
            }

            endTime = System.nanoTime();

        } catch (IOException e) {
            System.out.println("Error in normal stream file copy.");
        } finally {
            try {
                // closing files properly
                if (fileInputSystem != null) 
                if (fileOutputSystem!= null) fileOutputSystem.close();
            } catch (IOException e) {
                System.out.println("Error while closing normal stream.");
            }
        }

        return (endTime - startTime);
    }

    // method for copying file using BufferedInputStream and BufferedOutputStream
    public static long copyUsingBufferedStream(String source, String dest) {

        BufferedInputStream bufferInputStream = null;
        BufferedOutputStream bufferOutputStream = null;

        byte[] buffer = new byte[4096]; // 4KB chunk
        int bytesRead;

        long startTime = 0;
        long endTime = 0;

        try {
            bufferInputStream = new BufferedInputStream(new FileInputStream(source));
            bufferOutputStream = new BufferedOutputStream(new FileOutputStream(dest));

            startTime = System.nanoTime();

            // buffered stream copy process
            while ((bytesRead = bufferInputStream.read(buffer)) != -1) {
                bufferOutputStream.write(buffer, 0, bytesRead);
            }

            endTime = System.nanoTime();

        } catch (IOException e) {
            System.out.println("Error in buffered stream file copy.");
        } finally {
            try {
                // closing buffered streams
                if (bufferInputStream != null) 
                if (bufferInputStream != null) bufferInputStream.close();
            } catch (IOException e) {
                System.out.println("Error while closing buffered stream.");
            }
        }

        return (endTime - startTime);
    }
}
