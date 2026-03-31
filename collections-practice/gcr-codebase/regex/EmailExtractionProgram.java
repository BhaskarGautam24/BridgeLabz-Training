import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmailExtractionProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput;

        System.out.println("Enter text:");
        textInput = scanner.nextLine();

        extractEmails(textInput);
    }

    public static void extractEmails(String textInput) {

        String emailPattern;

        Pattern pattern;
        Matcher matcher;

        emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(textInput);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
