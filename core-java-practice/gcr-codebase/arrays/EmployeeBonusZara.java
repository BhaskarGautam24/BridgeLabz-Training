package arrays;
import java.util.*;
public class EmployeeBonusZara {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // Input salaries and years of service
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = scn.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double years = scn.nextDouble();
            
            if (salary < 0 || years < 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // Decrement index to repeat input for this employee
                continue;
            }
            
            salaries[i] = salary;
            yearsOfService[i] = years;
        }
        
        // Calculate bonuses and new salaries
        for (int i = 0; i < 10; i++) {
            double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];
            
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        
        // Print totals
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
    }
}
