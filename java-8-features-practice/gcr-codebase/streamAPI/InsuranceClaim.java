import java.util.*;
import java.util.stream.*;
public class InsuranceClaim{
    public static void main(String[] args){

        class Claim {
            String type;
            double amount;

            Claim(String type, double amount){
                this.type = type;
                this.amount = amount;
            }
        }

        List<Claim> claims = new ArrayList<Claim>();
        claims.add(new Claim("Health", 5000));
        claims.add(new Claim("Health", 7000));
        claims.add(new Claim("Vehicle", 12000));
        claims.add(new Claim("Vehicle", 8000));

        Map<String, Double> result =
                claims.stream()
                        .collect(Collectors.groupingBy(
                                c -> c.type,
                                Collectors.averagingDouble(c -> c.amount)
                        ));

        result.forEach((k, v) ->
                System.out.println(k + " average claim is " + v));
    }
}
