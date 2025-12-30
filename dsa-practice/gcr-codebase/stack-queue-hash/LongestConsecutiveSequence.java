import java.util.*;
// interface for logic
interface SequenceCheck {
    // method for finding length
    int getLength(int[] arr);
}
// abstract class
abstract class SequenceBase {
    // concrete method
    public void showMsg() {
        // small info msg
        System.out.println("checking sequence now");
    }
    // abstract method
    public abstract int calculate(int[] arr);
}
// child class
class ConsecutiveSequence extends SequenceBase implements SequenceCheck {
    // overriding abstract method
    @Override
    public int calculate(int[] arr) {
        // calling main logic
        return getLength(arr);
    }

    // overriding interface method
    @Override
    public int getLength(int[] arr) {

        // hashmap for storing values
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        // variable for max count
        int maxCount = 0;

        // storing array values
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }
        // loop to find sequence
        for (int i = 0; i < arr.length; i++) {
            // checking start point
            int prev = arr[i] - 1;

            if (!map.containsKey(prev)) {

                // starting count
                int current = arr[i];
                int count = 1;

                // checking next numbers
                while (map.containsKey(current + 1)) {
                    current = current + 1;
                    count = count + 1;
                }
                // updating max
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }

        // returning answer
        return maxCount;
    }
}
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("enter size: ");
        int size = scn.nextInt();
        // array declaration
        int[] arr = new int[size];
        // taking elements
        System.out.println("enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scn.nextInt();
        }
        // parent reference
        SequenceBase seq = new ConsecutiveSequence();
        // checking instance
        if (seq instanceof ConsecutiveSequence) {
            seq.showMsg();
        }

        // getting result
        int result = seq.calculate(arr);
        // printing output
        System.out.println("longest length is: " + result);
    }
}
