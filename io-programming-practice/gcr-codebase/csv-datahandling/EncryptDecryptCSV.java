import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class EncryptDecryptCSV {
    // Simple encryption method
    public static String encrypt(String text) {
        String result="";

        for (int i=0;i<text.length();i++) {
            char ch=text.charAt(i);
            ch=(char)(ch+2);
            result=result+ch;
        }
        return result;
    }
    // Simple decryption method
    public static String decrypt(String text) {
        String result="";

        for (int i=0;i<text.length();i++) {
            char ch=text.charAt(i);
            ch = (char)(ch-2);
            result=result+ch;
        }
        return result;
    }

    public static void main(String[] args) {

        try {
            FileWriter writer=new FileWriter("employees_secure.csv");

            writer.write("ID,Name,Email,Salary\n");

            writer.write("201,Rahul,"+encrypt("rahul@gmail.com")+","+encrypt("45000")+"\n");
            writer.write("202,Anita,"+encrypt("anita@yahoo.com")+","+encrypt("40000")+"\n");
            System.out.println("Encrypted data written into CSV file\n");

            File file = new File("employees_secure.csv");
            Scanner sc = new Scanner(file);

            if (sc.hasNextLine()) {
                sc.nextLine();
            }

            System.out.println("Decrypted Employee Data:\n");

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];
                String email = decrypt(data[2]);
                String salary = decrypt(data[3]);

                System.out.println("ID     : " + id);
                System.out.println("Name   : " + name);
                System.out.println("Email  : " + email);
                System.out.println("Salary : " + salary);
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            System.out.println("Error occured during encrypt or decrypt process");
        }
    }
}

