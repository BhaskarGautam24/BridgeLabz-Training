import java.util.*;
class StockSpanProblem {
    public static void calculateSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        // First day span is always 1
        span[0] = 1;
        stack.push(0);
        // Calculate span for remaining days
        for (int i = 1; i < n; i++) {
            // Remove indices with smaller or equal prices
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // If stack empty, span is i + 1
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            // Push current index
            stack.push(i);
        }
        // Print result
        System.out.println("Stock Spans:");
        for (int i = 0; i < n; i++) {
            System.out.print(span[i] + " ");
        }
    }   
    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        calculateSpan(prices);
    }
}
