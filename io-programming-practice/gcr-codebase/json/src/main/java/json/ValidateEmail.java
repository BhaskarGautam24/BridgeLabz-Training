package json;

import java.io.InputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateEmail {

    public static void main(String[] args) {

        try {

            // create mapper
            ObjectMapper mapper = new ObjectMapper();

            // read user json file
            InputStream userFile =
                    ValidateEmail.class.getClassLoader().getResourceAsStream("data.json");

            // read schema json file
            InputStream schemaFile =
                    ValidateEmail.class.getClassLoader().getResourceAsStream("schema.json");

            // convert both files to JsonNode
            JsonNode dataJson = mapper.readTree(userFile);
            JsonNode schemaJson = mapper.readTree(schemaFile);

            // check if email is required in schema
            boolean emailRequired =
                    schemaJson.get("required").toString().contains("email");

            // get email value from user json
            String email = dataJson.get("email").asText();

            // apply schema rule manually
            if (emailRequired && email.contains("@") && email.contains(".")) {
                System.out.println("Email is valid according to schema");
            } else {
                System.out.println("Email is invalid according to schema");
            }

        } catch (Exception e) {
            System.out.println("Error while validating email");
        }
    }
}
