import java.util.*;
public class Transformation{
    public static void main(String[] args){
        List<String> names = new ArrayList<String>();
        names.add("rahul");
        names.add("amit");
        names.add("neha");
        names.stream()
                .map(n -> n.toUpperCase())
                .sorted()
                .forEach(n -> System.out.println(n));   }
}
