import java.util.*;
interface FibCheck {
    void check(int n);
}
abstract class FibBase {
    private String name;
    FibBase(String name) {
        this.name = name;
    }
    // abstract fibonacci method
    abstract int fib(int n);
    void show() {
        System.out.println("\nmethod : " + name);
    }
}

// recursive fibonacci
class RecursiveFib extends FibBase implements FibCheck {
    RecursiveFib() {
        super("recursive");
    }

    // recursive logic
    int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // time logic
    public void check(int n) {
        long start = System.currentTimeMillis();
        int result = fib(n);
        long end = System.currentTimeMillis();
        System.out.println("value : " + result);
        System.out.println("time  : " + (end - start) + " ms");
    }
}
class IterativeFib extends FibBase implements FibCheck {         
    IterativeFib() {
        super("iterative");
    }

    // loop logic
    int fib(int n) {

        int first = 0;
        int second = 1;
        int sum = 0;

        if (n == 0) {
            return first;
        }

        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    // time logic
    public void check(int n) {
        long start = System.currentTimeMillis();
        int result = fib(n);
        long end = System.currentTimeMillis();
        System.out.println("value : " + result);
        System.out.println("time  : " + (end - start) + " ms");
    }
}
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter n : ");
        int n = scn.nextInt();
        // parent reference
        FibBase fib;
        fib = new RecursiveFib();
        fib.show();
        ((FibCheck) fib).check(n);

        // iterative call
        fib = new IterativeFib();
        fib.show();
        ((FibCheck) fib).check(n);
    }
}
