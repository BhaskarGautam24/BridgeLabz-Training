import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // map for storing key and value
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // taking number of entries
        int n = sc.nextInt();

        // input loop for map
        for (int i = 0; i < n; i++) {
            String key = sc.next();      // key is read here
            int value = sc.nextInt();    // value is read here
            map.put(key, value);         // put key value in map
        }

        // assume first max value is very small
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // loop for finding max value key
        for (String k : map.keySet()) {

            int v = map.get(k);

            // if current value is big then previous
            if (v > maxValue) {
                maxValue = v;   // update max value
                maxKey = k;     // store key also
            }
        }

        // printing key which have highest value
        System.out.println(maxKey);
    }
}

