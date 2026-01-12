import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ProgrammingLanguageExtractionProgram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inputText;

        System.out.println("Enter text:");
        inputText = sc.nextLine();
        extractLanguages(inputText);

    }

    public static void extractLanguages(String inputText) {

        String languagePattern;

        // Pattern and Matcher object declaration
        Pattern pattern;
        Matcher matcher;
        languagePattern = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|PHP|Ruby|C)\\b";

        // Compiling regex pattern
        pattern = Pattern.compile(languagePattern);

        // Creating matcher for input text
        matcher = pattern.matcher(inputText);

        // Finding and printing each matched language
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

