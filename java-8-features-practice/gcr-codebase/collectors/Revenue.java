import java.util.*;
import java.util.stream.*;
public class Revenue{
    public static void main(String[] args){
        List<Map.Entry<String,Double>> orders=new ArrayList<>();
        orders.add(Map.entry("Bhaskar",1200.0));
        orders.add(Map.entry("Gaurav",900.0));
        orders.add(Map.entry("Manish",800.0));
        Map<String,Double> revenue=
        orders.stream()
        .collect(Collectors.groupingBy(
            Map.Entry::getKey,
            Collectors.summingDouble(Map.Entry::getValue)
        ));
        System.out.println(revenue);
    }
}
