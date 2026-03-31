import java.io.*;
import java.util.*;
public class ImageByteArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source image file name: ");
        String sourceImage = sc.nextLine();

        System.out.print("Enter destination image file name: ");
        String destImage = sc.nextLine();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        try {
            // reading image file
            fis = new FileInputStream(sourceImage);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;

            // reading image and converting into byte array
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            // converting ByteArrayOutputStream into byte array
            byte[] imageBytes = baos.toByteArray();

            // creating ByteArrayInputStream from byte array
            bais = new ByteArrayInputStream(imageBytes);
            fos = new FileOutputStream(destImage);

            // writing byte array back into image file
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Image converted to byte array and saved successfully.");
            System.out.println("New image is identical to original image.");

        } catch (IOException e) {
            // handle file read or write error
            System.out.println("Error while processing image file.");
        } finally {
            try {
                // closing all resources properly
                if (fis != null) fis.close();
                if (fos != null) fos.close();
                if (baos != null) baos.close();
                if (bais != null) bais.close();
            } catch (IOException e) {
                System.out.println("Error while closing resources.");
            }
        }
    }
}
