import java.util.*;
public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter value of N: ");
        int n = scn.nextInt();
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        System.out.println("Binary Numbers:");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();

            System.out.println(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
