import java.util.*;
interface EmployeeInterface {
    void addCompany(String name, int wagePerHour, int maxDays, int maxHours);
    void addEmployee(String companyName, String empName,String empType, int workingHours);
    void computeWages();
    void getEmployeeWage(String companyName, String empName);
    void getCompanyTotalWage(String companyName);
}
class Employee {
    String employeeName;
    String employeeType;   
    int fixedWorkingHours; 
    int totalWage;
    int totalWorkingDays;
    int totalWorkingHours;
    ArrayList<Integer> dailyWages;
    public Employee(String name, String type, int hours) {
        this.employeeName = name;
        this.employeeType = type;
        this.fixedWorkingHours = hours;
        this.totalWage = 0;
        this.totalWorkingDays = 0;
        this.totalWorkingHours = 0;
        this.dailyWages = new ArrayList<>();
    }
}
class CompanyEmpWage {
    String companyName;
    int wagePerHour;
    int maxWorkingDays;
    int maxWorkingHours;
    ArrayList<Employee> employeeList;
    public CompanyEmpWage(String name, int wage,int maxDays, int maxHours) {

        this.companyName=name;
        this.wagePerHour=wage;
        this.maxWorkingDays=maxDays;
        this.maxWorkingHours=maxHours;
        this.employeeList=new ArrayList<>();
    }
}
class EmpWageBuilder implements EmployeeInterface {
    ArrayList<CompanyEmpWage> companyList;
    public EmpWageBuilder() {companyList = new ArrayList<>();
    }
    public void addCompany(String name, int wagePerHour,int maxDays, int maxHours) {
        CompanyEmpWage company =new CompanyEmpWage(name, wagePerHour, maxDays, maxHours);
        companyList.add(company);
        System.out.println("Company Added Successfully.");
    }
    public void addEmployee(String companyName, String empName,String empType, int workingHours) {
        for (CompanyEmpWage company : companyList) {
            if (company.companyName.equals(companyName)) {
                Employee emp=new Employee(empName, empType, workingHours);
                company.employeeList.add(emp);
                System.out.println("Employee Added Successfully.");
                return;
            }
        }
        System.out.println("Company Not Found.");
    }
    public void computeWages() {
        Random random=new Random();
        for (CompanyEmpWage company:companyList){
            for (Employee emp:company.employeeList){
                emp.totalWorkingDays = 0;
                emp.totalWorkingHours = 0;
                emp.totalWage = 0;
                emp.dailyWages.clear();
                while (emp.totalWorkingDays<company.maxWorkingDays &&
                        emp.totalWorkingHours<company.maxWorkingHours){
                    emp.totalWorkingDays++;
                    int attendance=random.nextInt(2); 
                    int hoursWorked=0;
                    if (attendance==1) { 
                        hoursWorked=emp.fixedWorkingHours;
                    } else {
                        hoursWorked=0;  
                    }

                    emp.totalWorkingHours+=hoursWorked;
                    int dailyWage = hoursWorked * company.wagePerHour;
                    emp.dailyWages.add(dailyWage);
                    emp.totalWage+=dailyWage;
                }
            }
        }
        System.out.println("Wages Computed Successfully.");
    }
    public void getEmployeeWage(String companyName, String empName) {
        for (CompanyEmpWage company:companyList) {

            if (company.companyName.equals(companyName)) {
                for (Employee emp:company.employeeList) {
                    if (emp.employeeName.equals(empName)) {
                        System.out.println("\nEmployee Name: " + emp.employeeName);
                        System.out.println("Employee Type: " + emp.employeeType);
                        System.out.println("Total Working Days: " + emp.totalWorkingDays);
                        System.out.println("Total Working Hours: " + emp.totalWorkingHours);
                        System.out.println("Daily Wages: " + emp.dailyWages);
                        System.out.println("Monthly Wage: " + emp.totalWage);
                        return;
                    }
                }
            }
        }
        System.out.println("Employee Not Found.");
    }
    public void getCompanyTotalWage(String companyName) {
        for (CompanyEmpWage company:companyList) {
            if (company.companyName.equals(companyName)) {
                int total=0;
                for (Employee emp:company.employeeList) {
                    total+=emp.totalWage;
                }
                System.out.println("Total Company Wage: "+total);
                return;
            }
        }
        System.out.println("Company Not Found.");
    }
}
public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Scanner sc=new Scanner(System.in);
        EmpWageBuilder builder=new EmpWageBuilder();
        int choice;
        do {
            System.out.println("\n1. Add Company");
            System.out.println("2. Add Employee");
            System.out.println("3. Compute Wages");
            System.out.println("4. View Single Employee Wage");
            System.out.println("5. View Company Total Wage");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Company Name: ");
                    String cname = sc.next();
                    System.out.print("Wage Per Hour: ");
                    int wage = sc.nextInt();
                    System.out.print("Max Working Days (20): ");
                    int days = sc.nextInt();
                    System.out.print("Max Working Hours (100): ");
                    int hours = sc.nextInt();
                    builder.addCompany(cname, wage, days, hours);
                    break;
                case 2:
                    System.out.print("Company Name: ");
                    String compName = sc.next();
                    System.out.print("Employee Name: ");
                    String empName = sc.next();
                    System.out.print("Employee Type (FullTime/PartTime): ");
                    String type = sc.next();
                    System.out.print("Working Hours per Day (8 for FT / 4 for PT): ");
                    int wh = sc.nextInt();
                    builder.addEmployee(compName, empName, type, wh);
                    break;
                case 3:
                    builder.computeWages();
                    break;
                case 4:
                    System.out.print("Company Name: ");
                    String c1 = sc.next();
                    System.out.print("Employee Name: ");
                    String e1 = sc.next();
                    builder.getEmployeeWage(c1, e1);
                    break;
                case 5:
                    System.out.print("Company Name: ");
                    String c2 = sc.next();
                    builder.getCompanyTotalWage(c2);
                    break;
                case 6:
                    System.out.println("Program Ended.");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 6);
    }
}
