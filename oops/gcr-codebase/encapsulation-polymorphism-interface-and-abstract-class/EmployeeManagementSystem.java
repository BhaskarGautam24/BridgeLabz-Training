import java.util.*;
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int id;
        String name;
        double baseSalary;
        double hoursWorked;
        String deptName;

        System.out.println("enter full-time employee id:");
        id = scn.nextInt();
        scn.nextLine();

        System.out.println("enter full-time employee name:");
        name = scn.nextLine();

        System.out.println("enter base salary:");
        baseSalary = scn.nextDouble();
        scn.nextLine();

        // creating full-time employee object
        Employee emp1 = new FullTimeEmployee(id, name, baseSalary);

        // assign department
        System.out.println("enter department for full-time employee:");
        deptName = scn.nextLine();
        ((Department)emp1).assignDepartment(deptName);

        // display full-time employee details
        emp1.displayDetails();
        System.out.println(((Department)emp1).getDepartmentDetails());
        System.out.println("calculated salary: " + emp1.calculateSalary());

        System.out.println("\nenter part-time employee id:");
        id = scn.nextInt();
        scn.nextLine();

        System.out.println("enter part-time employee name:");
        name = scn.nextLine();

        System.out.println("enter base salary per hour:");
        baseSalary = scn.nextDouble();

        System.out.println("enter hours worked:");
        hoursWorked = scn.nextDouble();
        scn.nextLine();

        // creating part-time employee object
        Employee emp2 = new PartTimeEmployee(id, name, baseSalary, hoursWorked);

        // assign department
        System.out.println("enter department for part-time employee:");
        deptName = scn.nextLine();
        ((Department)emp2).assignDepartment(deptName);

        // display part-time employee details
        emp2.displayDetails();
        System.out.println(((Department)emp2).getDepartmentDetails());
        System.out.println("calculated salary: " + emp2.calculateSalary());
    }
}
// abstract employee class
abstract class Employee implements Department {

    private int employeeId;
    private String name;
    private double baseSalary;

    // constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // getters
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    // setters
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setName(String name) { this.name = name; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // abstract method to calculate salary
    public abstract double calculateSalary();

    // concrete method to display details
    public void displayDetails() {
        System.out.println("employee id: " + employeeId);
        System.out.println("name: " + name);
        System.out.println("base salary: " + baseSalary);
    }
}

// full-time employee class
class FullTimeEmployee extends Employee {

    // variable for department
    private String department;

    // constructor
    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    // calculate salary for full-time
    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    // assign department
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    // get department details
    @Override
    public String getDepartmentDetails() {
        return "department: " + department;
    }
}

// part-time employee class
class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private String department;

    // constructor
    public PartTimeEmployee(int id, String name, double baseSalary, double hoursWorked) {
        super(id, name, baseSalary);
        this.hoursWorked = hoursWorked;
    }

    // calculate salary based on hours
    @Override
    public double calculateSalary() {
        return getBaseSalary() * hoursWorked;
    }

    // assign department
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    // get department details
    @Override
    public String getDepartmentDetails() {
        return "department: " + department;
    }
}

// department interface
interface Department {

    // method to assign department
    void assignDepartment(String deptName);

    // method to get department info
    String getDepartmentDetails();
}

