import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordExtractionProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String sentence;

        System.out.println("Enter a sentence:");
        sentence = scanner.nextLine();

        extractCapitalizedWords(sentence);

    }
    public static void extractCapitalizedWords(String sentence) {

        String capitalWordPattern;

        Pattern pattern;
        Matcher matcher;

        capitalWordPattern = "\\b[A-Z][a-z]*\\b";

        pattern = Pattern.compile(capitalWordPattern);

        matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
