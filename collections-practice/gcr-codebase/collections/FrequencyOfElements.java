import java.util.*;
public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create list
        ArrayList<String> list = new ArrayList<String>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }
        // create map
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        // count frequency
        for (int i = 0; i < list.size(); i++) {

            String key = list.get(i);

            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        System.out.println("Frequency of elements: " + map);
    }
}

