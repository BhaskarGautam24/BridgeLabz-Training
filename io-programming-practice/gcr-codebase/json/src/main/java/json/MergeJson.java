package json;
import java.io.InputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) {
        try {
           
            ObjectMapper mapper = new ObjectMapper();
            // read first json file
            InputStream file1 =
                    MergeJson.class.getClassLoader().getResourceAsStream("data.json");
            // read second json file
            InputStream file2 =
                    MergeJson.class.getClassLoader().getResourceAsStream("user.json");
            // convert to JsonNode
            ObjectNode json1 = (ObjectNode) mapper.readTree(file1);
            ObjectNode json2 = (ObjectNode) mapper.readTree(file2);
            // merge json2 into json1
            json1.setAll(json2);
            String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Error while merging json");
        }
    }
}
