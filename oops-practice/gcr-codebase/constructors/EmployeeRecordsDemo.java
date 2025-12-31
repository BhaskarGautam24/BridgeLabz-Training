import java.util.*;
public class EmployeeRecordsDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int employeeID = scn.nextInt();
        scn.nextLine();
        String department = scn.nextLine();
        double salary = scn.nextDouble();

        // creating manager object
        Manager manager = new Manager(employeeID, department, salary);

        // showing manager info
        manager.showManagerDetails();

        // updating salary
        double newSalary = scn.nextDouble();
        manager.setSalary(newSalary);

        // showing updated salary
        System.out.println("updated salary: " + manager.getSalary());
    }
}
class Employee {
    
    public int employeeID;
    protected String department;
    private double salary;

    // parameterized constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // getter for salary
    public double getSalary() {
        return salary;
    }

    // setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// subclass for manager
class Manager extends Employee {

    // constructor calling parent
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // method to show manager details
    public void showManagerDetails() {
        System.out.println("employee id: " + employeeID);
        System.out.println("department: " + department);
        System.out.println("salary: " + getSalary());
    }
}
