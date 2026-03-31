package json;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertListToArray {
    public static void main(String[] args) {
        // Create ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();

        try {

            // Create list of Student objects
            List<Student> list = new ArrayList<Student>();
            list.add(new Student(1, "Bhaskar", 22));
            list.add(new Student(2, "Arman", 23));
            list.add(new Student(3, "Gaurav", 22));

            // Convert list into JSON array string
            String jsonArray = mapper.writeValueAsString(list);

            // Print JSON array
            System.out.println(jsonArray);

        } catch (Exception e) {
            System.out.println("Something went wrong while converting list to json");
            e.printStackTrace(); 
        }
    }
}
