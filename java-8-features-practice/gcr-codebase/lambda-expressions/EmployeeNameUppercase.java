import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class EmployeeNameUppercase {

    public static void main(String[] args) {
        ArrayList<String> employeeNames = new ArrayList<>();
        employeeNames.add("Aditya");
        employeeNames.add("Bhaskar");
        employeeNames.add("Arman");
        employeeNames.add("Gaurav");
        List<String> upperCaseNames = employeeNames.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Employee Names for HR Letter:");
        upperCaseNames.forEach(System.out::println);
    }
}

