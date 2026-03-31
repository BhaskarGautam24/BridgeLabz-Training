import java.util.*;
public class FlipKey
{
    public static String CleanseAndInvert(String input)
    {
        if (input == null || input.length() < 6)
        {
            return "";
        }
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);

            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')))
            {
                return "";
            }
        }
        input = input.toLowerCase();
        String filtered = "";
        for (int i = 0; i < input.length(); i++)
        {
            int ascii = (int) input.charAt(i);

            if (ascii % 2 != 0)
            {
                filtered = filtered + input.charAt(i);
            }
        }
        String reversed = "";
        for (int i = filtered.length() - 1; i >= 0; i--)
        {
            reversed = reversed + filtered.charAt(i);
        }
        char[] result = reversed.toCharArray();
        for (int i = 0; i < result.length; i++)
        {
            if (i % 2 == 0)
            {
                result[i] = Character.toUpperCase(result[i]);
            }
        }

        return new String(result);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String input = sc.nextLine();

        String output = CleanseAndInvert(input);

        if (output.equals(""))
        {
            System.out.println("Invalid Input");
        }
        else
        {
            System.out.println("The generated key is - " + output);
        }
    }
}
