package strings;
import java.util.*;
public class TextToWords {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String text = scn.nextLine();                      // Read input text
    String[] wordsUsingCustomMethod = splitText(text);
    String[] wordsUsingBuiltInMethod = text.split(" ");
    boolean areEqual = compareArrays(wordsUsingCustomMethod, wordsUsingBuiltInMethod);              // Call the comparison method

    if(areEqual){
      System.out.println("The methods produce the same result.");
    }
    else{
      System.out.println("The methods produce different results.");
    }
  }
  public static int length(String text){
    int count=0;
    while(true){
      try{
      text.charAt(count);
      count++;
      }
      catch(StringIndexOutOfBoundsException e){
        break;
      }
    return count;

    }
  }
  public static String[] splitText(String text){
    int wordCount=1;
    int length = length(text);
    for(int i=0;i<length;i++){
      if(text.charAt(i)==' '){
        wordCount++;
      }
    }
    String[] words = new String[wordCount];                          // Create array to hold words
    int index=0;
    int start=0;
    for(int i=0;i<length;i++){
      if(text.charAt(i)==' '){
        words[index]=text.substring(start,i);
        index++;
        start=i+1;
      }
    }
    words[index]=text.substring(start,length);
    return words;
  }
  public static boolean compareArrays(String[] arr1, String[] arr2){
    if(arr1.length != arr2.length){                             // Check if lengths are different
      return false;
    }
    for(int i=0;i<arr1.length;i++){              // Compare each element
      if(!arr1[i].equals(arr2[i])){
        return false;
      }
    }
    return true;
  }



  
}
