import java.util.*;
import java.util.stream.*;
public class Frequency{
    public static void main(String[] args){
        String text="bhaskar gautam bhaskar gautam";
        Map<String,Integer> countMap=
        Arrays.stream(text.split(" "))
        .collect(Collectors.toMap(
            word->word,
            word->1,
            (oldValue,newValue)->oldValue+newValue
        ));
        System.out.println(countMap);
    }
}
