package extras;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = scn.nextLine();

        // input date
        LocalDate date = LocalDate.parse(input, formatter);
        System.out.println("Original Date: " + date.format(formatter));

        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After Adding 7 days, 1 month, 2 years: " + newDate.format(formatter));

        // Subtract 3 weeks
        LocalDate finalDate = newDate.minusWeeks(3);
        System.out.println("After Subtracting 3 weeks: " + finalDate.format(formatter));
    }
}

