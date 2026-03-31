import java.util.*;
interface Reverser {
    // method to reverse string
    String reverseText(String text);
}
// abstract class for common behaviour
abstract class BaseReverser implements Reverser {

    // concrete method for message
    public void showProcess() {
        // simple info message
        System.out.println("reversing string using stringbuilder");
    }
    // abstract method must be override
    public abstract String reverseText(String text);
}

// child class using stringbuilder
class StringBuilderReverser extends BaseReverser {
    // private variable for input text
    private String inputText;

    // setter method
    public void setInputText(String inputText) {
        // assigning value using this
        this.inputText = inputText;
    }
    // getter method
    public String getInputText() {
        // returning input value
        return this.inputText;
    }
    // overriding reverse method
    @Override
    public String reverseText(String text) {

        // variable for stringbuilder
        StringBuilder sb;

        // creating stringbuilder object
        sb = new StringBuilder();

        // appending text
        sb.append(text);

        // reversing string
        sb.reverse();

        // converting to string
        String result = sb.toString();

        // returning final result
        return result;
    }
}
public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter a string to reverse");
        // storing user input
        String userInput = scn.nextLine();

        // parent reference for polymorphism
        BaseReverser reverser = new StringBuilderReverser();

        // checking object type
        if (reverser instanceof StringBuilderReverser) {
            // casting to child class
            StringBuilderReverser sbReverser = (StringBuilderReverser) reverser;
            // setting input text
            sbReverser.setInputText(userInput);
            // showing process message
            sbReverser.showProcess();
            // reversing string
            String output = sbReverser.reverseText(sbReverser.getInputText());
            // printing result
            System.out.println("reversed string is: " + output);
        }
    }
}
