package json;
import java.io.InputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            // object mapper for json
            ObjectMapper jsonMapper = new ObjectMapper();
            InputStream file =JsonToXml.class.getClassLoader().getResourceAsStream("data.json");
            JsonNode jsonNode = jsonMapper.readTree(file);
            // xml mapper
            XmlMapper xmlMapper = new XmlMapper();
            // convert json to xml string
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(xml);
        } catch (Exception e) {
            System.out.println("Error while converting json to xml");
        }
    }
}
