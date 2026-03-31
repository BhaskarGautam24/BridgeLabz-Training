package json;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // read csv file
            InputStream file =
                    CsvToJson.class.getClassLoader().getResourceAsStream("Info.csv");
           BufferedReader br = new BufferedReader(new InputStreamReader(file));

            String[] headers = br.readLine().split(",");
            String ln;

            // loop through csv rows
            while ((ln = br.readLine()) != null) {
                String[] val = ln.split(",");

                ObjectNode json = mapper.createObjectNode();
                // loop to put values
                for (int i = 0; i < headers.length; i++) {
                    json.put(headers[i], val[i]);
                }
                System.out.println(json);
            }
        } catch (Exception e) {
            System.out.println("Error while converting csv");
        }
    }
}
