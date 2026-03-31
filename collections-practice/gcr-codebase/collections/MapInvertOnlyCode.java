import java.util.*;
public class MapInvertOnlyCode {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        // original map
        HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            String k = scn.next();
            int v = scn.nextInt();
            dataMap.put(k, v);
        }
        // inverted map
        HashMap<Integer, ArrayList<String>> resultMap =
                new HashMap<Integer, ArrayList<String>>();

        for (String key : dataMap.keySet()) {

            int val = dataMap.get(key);

            if (resultMap.containsKey(val)) {
                resultMap.get(val).add(key);
            } else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(key);
                resultMap.put(val, tempList);
            }
        }
        System.out.println(resultMap);
    }
}

