import java.util.*;
class SortStackUsingRecursion {
    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base condition
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Remove top element
        int topElement = stack.pop();

        // Step 2: Sort remaining stack
        sortStack(stack);
        
        // Step 3: Insert element at correct position
        insertSorted(stack, topElement);
    }
    // Function to insert element in sorted stack
    public static void insertSorted(Stack<Integer> stack, int element) {
        // Base condition
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        // Remove top and recurse
        int top = stack.pop();
        insertSorted(stack, element);

        // Put back the removed element
        stack.push(top);
    }
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}

