import java.util.*;

public class FootballHeights {

    // Sum of heights
    static int sum(int[] h) {
        int s = 0;
        for (int i = 0; i < h.length; i++)
            s += h[i];
        return s;
    }

    // Mean height
    static double mean(int[] h) {
        return (double) sum(h) / h.length;
    }

    // Shortest height
    static int shortest(int[] h) {
        int min = h[0];
        for (int i = 1; i < h.length; i++)
            if (h[i] < min) min = h[i];
        return min;
    }

    // Tallest height
    static int tallest(int[] h) {
        int max = h[0];
        for (int i = 1; i < h.length; i++)
            if (h[i] > max) max = h[i];
        return max;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];
        Random r = new Random();

        // Random heights (150–250)
        for (int i = 0; i < heights.length; i++)
            heights[i] = r.nextInt(101) + 150;

        System.out.println("Shortest : " + shortest(heights));
        System.out.println("Tallest  : " + tallest(heights));
        System.out.println("Mean     : " + mean(heights));
    }
}
