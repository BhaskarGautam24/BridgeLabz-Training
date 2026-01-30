import java.util.*;
public class sensor{
    public static void main(String[] args){
        List<Integer> readings = new ArrayList<Integer>();
        readings.add(45);
        readings.add(78);
        readings.add(30);
        readings.add(90);
        readings.stream()
                .filter(r -> r > 50)
                .forEach(r -> System.out.println("High reading : "+r));
    }
}
