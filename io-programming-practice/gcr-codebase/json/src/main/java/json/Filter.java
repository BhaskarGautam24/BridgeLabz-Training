package json;
import java.io.InputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Filter {
    public static void main(String[] args) {
        // ObjectMapper for read json
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Load json file from resources
            InputStream input = Filter.class
                    .getClassLoader()
                    .getResourceAsStream("users.json");

            // Read json as tree
            JsonNode users = mapper.readTree(input);
            for (int i = 0; i < users.size(); i++) {

                JsonNode user = users.get(i);

                int age = user.get("age").asInt();
                if (age > 25) {
                    System.out.println(
                            "Name = " + user.get("name").asText()
                            + " , Age = " + age
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Error while reading json");
        }
    }
}
