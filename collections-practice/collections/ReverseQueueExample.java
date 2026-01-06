import java.util.*;
public class ReverseQueueExample {

    static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }

        int front = q.remove();
        reverseQueue(q);
        q.add(front);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<Integer>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        // reverse queue
        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}

