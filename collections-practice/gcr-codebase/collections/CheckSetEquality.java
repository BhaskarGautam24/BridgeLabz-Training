import java.util.*;
public class CheckSetEquality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // first set
        HashSet<Integer> set1 = new HashSet<Integer>();
        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }
        // second set
        HashSet<Integer> set2 = new HashSet<Integer>();

        System.out.print("Enter number of elements in Set2: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }
        boolean result = true;
       if (set1.size() != set2.size()) {
            result = false;
        } else {
            for (Integer value : set1) {
                if (!set2.contains(value)) {
                    result = false;
                    break;
                }
            }
        }
        System.out.println("Are both sets equal? " + result);
    }
}
