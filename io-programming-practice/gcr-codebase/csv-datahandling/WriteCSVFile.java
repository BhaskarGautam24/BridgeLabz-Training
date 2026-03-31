import java.io.*;
import java.io.IOException;
public class WriteCSVFile {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            // Creating CSV file for storing employee data
            writer = new FileWriter("employees.csv");

            // Writing header line in csv file
            writer.write("ID,Name,Department,Salary");

            // Writing employee records one by one
            // Each data is seperated by comma
            writer.write("201,Rahul,IT,45000\n");
            writer.write("202,Anita,HR,40000\n");
            writer.write("203,Aman,Finance,50000\n");
            writer.write("204,Priya,Marketing,42000\n");
            writer.write("205,Suresh,Admin,38000\n");

            // Data is saved into file
            writer.close();

            System.out.println("Employee data written successfully in CSV file");

        } catch (IOException e) {                              
            System.out.println("Problem occured while writing file");
        }
    }
}
