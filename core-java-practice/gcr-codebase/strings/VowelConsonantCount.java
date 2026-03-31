package strings;
import java.util.*;
public class VowelConsonantCount {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String str = scn.nextLine();
    int[] counts = countVowelsAndConsonants(str);               // method works to count vowels and consonants
    System.out.println("Number of Vowels: " + counts[0]);
    System.out.println("Number of Consonants: " + counts[1]);
  }
  public static String checkCharType(char ch){
    if(ch >= 'A' && ch <= 'Z'){
      ch = (char)(ch + 32); // Convert to lowercase
    }
    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
      return "Vowel";
    }
    else if(ch >= 'a' && ch <= 'z'){
      return "Consonant";
    }
    else{
      return "Not a Letter";
    }
  }
  public static int[] countVowelsAndConsonants(String str){
    int vowelCount = 0;
    int consonantCount = 0;
    int length = str.length();
    for(int i = 0; i < length; i++){
      char ch = str.charAt(i);
      String type = checkCharType(ch);
      if(type.equals("Vowel")){
        vowelCount++;
      }
      else if(type.equals("Consonant")){
        consonantCount++;
      }
    }
    return new int[]{vowelCount, consonantCount};
  }
}