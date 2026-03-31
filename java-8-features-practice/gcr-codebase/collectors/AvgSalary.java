import java.util.*;
import java.util.stream.*;
class Employee{
    private String name;
    private String department;
    private double salary;
    Employee(String name,String department,double salary){
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    String getDepartment(){
        return department;
    }
    double getSalary(){
        return salary;
    }
}
public class AvgSalary{
    public static void main(String[] args){

        List<Employee> employees=Arrays.asList(
            new Employee("Anil","IT",60000),
            new Employee("Sunita","HR",45000),
            new Employee("Ramesh","IT",75000)
        );
        Map<String,Double> avgSalary=
        employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDepartment,
            Collectors.averagingDouble(Employee::getSalary)
        ));
        System.out.println(avgSalary);
    }
}
