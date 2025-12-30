import java.util.*;
class QueueUsingStacks {
    Stack<Integer> stackEnqueue;
    Stack<Integer> stackDequeue;
    // Constructor
    QueueUsingStacks() {
        stackEnqueue = new Stack<Integer>();
        stackDequeue = new Stack<Integer>();
    }
    // Enqueue operation
    public void enqueue(int value) {
        stackEnqueue.push(value);
        System.out.println(value + " enqueued");
    }
    // Dequeue operation
    public int dequeue() {
        // If both stacks are empty
        if (stackEnqueue.isEmpty() && stackDequeue.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        // Transfer elements if dequeue stack is empty
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        return stackDequeue.pop();
    }
    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Dequeued: " + queue.dequeue());
    }
}

