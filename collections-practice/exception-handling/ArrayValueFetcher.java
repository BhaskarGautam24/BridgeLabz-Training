import java.util.Scanner;
public class ArrayValueFetcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;

        int index;

        int[] numbers = null;

        try {
            System.out.print("Enter array size: ");
            size = scanner.nextInt();

            numbers = new int[size];

            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }

            System.out.print("Enter index to fetch value: ");
            index = scanner.nextInt();

            int value = numbers[index];

            System.out.println("Value at index " + index + ": " + value);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}

