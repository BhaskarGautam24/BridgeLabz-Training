package json;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CsvCensor {
    public static void main(String[] args) {
        try {
            InputStream file =
                    CsvCensor.class.getClassLoader().getResourceAsStream("ipl_matches.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(file));
            String header = br.readLine();
            System.out.println(header); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                data[1] = maskTeam(data[1]);
                data[2] = maskTeam(data[2]);
                data[5] = maskTeam(data[5]);
                // censor player name
                data[6] = "REDACTED";
                // print censored row
                System.out.println(String.join(",", data));
            }

        } catch (Exception e) {
            System.out.println("Error in CSV censor");
        }
    }

    // simple method
    static String maskTeam(String team) {
        return team.split(" ")[0] + " ***";
    }
}
