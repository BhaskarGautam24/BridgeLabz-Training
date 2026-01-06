import java.util.*;
public class RotateListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create list
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter rotation count: ");
        int k = sc.nextInt();
        k = k % list.size();
        for (int i = 0; i < k; i++) {
            int first = list.get(0);
            list.remove(0);
            list.add(first);
        }
        System.out.println("Rotated List: " + list);
    }
}

