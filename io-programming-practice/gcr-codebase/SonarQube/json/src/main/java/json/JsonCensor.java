package json;
import java.io.InputStream;
import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonCensor {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream file =JsonCensor.class.getClassLoader().getResourceAsStream("matches.json");

            ArrayNode matches = (ArrayNode) mapper.readTree(file);
            // loop matches
            for (JsonNode match : matches) {

                ObjectNode obj = (ObjectNode) match;
                // censor team names
                obj.put("team1", maskTeam(obj.get("team1").asText()));
                obj.put("team2", maskTeam(obj.get("team2").asText()));
                obj.put("winner", maskTeam(obj.get("winner").asText()));

                obj.put("player_of_match", "REDACTED");
            }
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matches));
        } catch (Exception e) {
            System.out.println("Error in JSON censor");
        }
    }

    static String maskTeam(String team) {
        return team.split(" ")[0] + " ***";
    }
}
