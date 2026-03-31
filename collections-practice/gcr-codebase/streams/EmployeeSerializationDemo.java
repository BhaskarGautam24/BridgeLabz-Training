import java.io.*;
import java.util.*;

public class EmployeeSerializationDemo implements Serializable {
    int id;
    String name;
    String department;
    double salary;
    public EmployeeSerializationDemo(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public void displayEmployee() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<EmployeeSerializationDemo> empList =
                new ArrayList<EmployeeSerializationDemo>();
        System.out.print("Enter number of employees: ");
        int count = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < count; i++) {

            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter department: ");
            String department = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            EmployeeSerializationDemo emp =
                    new EmployeeSerializationDemo(id, name, department, salary);

            empList.add(emp);
        }
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream("employees.dat"));

            // writing list into file
            oos.writeObject(empList);
            oos.close();

            System.out.println("\nEmployee data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving employee data.");
        }

        // deserialization process
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("employees.dat"));

            // reading list from file
            ArrayList<EmployeeSerializationDemo> readList =
                    (ArrayList<EmployeeSerializationDemo>) ois.readObject();

            System.out.println("\nEmployee details from file:");

            for (EmployeeSerializationDemo e : readList) {
                e.displayEmployee();
            }

            ois.close();

        } catch (IOException e) {
            System.out.println("Error while reading employee data.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization.");
        }
    }
}

