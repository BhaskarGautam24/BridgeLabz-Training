package json;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJsonEasy {
    public static void main(String[] args) {
        // JSON parser object
        JSONParser parser = new JSONParser();
        try {
            Reader reader = new InputStreamReader(
                    ReadJsonEasy.class
                            .getClassLoader()
                            .getResourceAsStream("data.json")
            );
            // Parse JSON
            Object obj = parser.parse(reader);
            // Convert to JSONObject
            JSONObject json = (JSONObject) obj;
            // Read values
            System.out.println("name = " + json.get("name"));
            System.out.println("age = " + json.get("age"));
            System.out.println("city = " + json.get("city"));
        } catch (Exception e) {
            System.out.println("Something went wrong while reading json");
            e.printStackTrace(); 
        }
    }
}
