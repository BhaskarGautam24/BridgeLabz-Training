import java.util.Scanner;

public class MultipleSpaceReplacementProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputText;

        String outputText;

        System.out.println("Enter text:");
        inputText = sc.nextLine();

        // Replacing multiple spaces with single space
        outputText = inputText.replaceAll("\\s{2,}", " ");

        // Printing final cleaned text
        System.out.println("Output:");
        System.out.println(outputText);

    }
}

