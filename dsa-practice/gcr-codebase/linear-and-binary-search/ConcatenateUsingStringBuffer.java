import java.util.*;
// interface for concatenate work
interface Concatenator {
    // method to join strings
    String joinStrings(String[] words);
}
// abstract class for base logic
abstract class BaseConcatenator implements Concatenator {
    // concrete method for info
    public void showInfo() {
        // small info msg
        System.out.println("joining strings using stringbuffer");
    }

    // abstract method
    public abstract String joinStrings(String[] words);
}
// child class using stringbuffer
class StringBufferConcatenator extends BaseConcatenator {

    // private variable for string array
    private String[] textArray;

    // setter method
    public void setTextArray(String[] textArray) {
        // assigning array using this
        this.textArray = textArray;
    }

    // getter method
    public String[] getTextArray() {
        // returning array
        return this.textArray;
    }

    // overriding join method
    @Override
    public String joinStrings(String[] words) {

        // stringbuffer variable
        StringBuffer buffer;
        // creating stringbuffer object
        buffer = new StringBuffer();
        // loop for concatenation
        for (int i = 0; i < words.length; i++) {
            // appending each string
            buffer.append(words[i]);
        }
        // converting to string
        String result = buffer.toString();

        // returning final text
        return result;
    }
}
public class ConcatenateUsingStringBuffer {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // asking array size
        System.out.println("enter number of strings");

        // storing size
        int size = scn.nextInt();
        scn.nextLine();

        // creating array
        String[] inputArray = new String[size];

        // loop for taking strings
        for (int i = 0; i < size; i++) {

            // asking string
            System.out.println("enter string " + (i + 1));

            // storing string
            inputArray[i] = scn.nextLine();
        }
        // parent reference for polymorphism
        BaseConcatenator concat = new StringBufferConcatenator();
        // checking instance
        if (concat instanceof StringBufferConcatenator) {

            // casting to child
            StringBufferConcatenator sbConcat = (StringBufferConcatenator) concat;

            // setting array
            sbConcat.setTextArray(inputArray);

            // showing info
            sbConcat.showInfo();
           // concatenating strings
            String output = sbConcat.joinStrings(sbConcat.getTextArray());
            // printing result
            System.out.println("final string is: " + output);
        }
    }
}
