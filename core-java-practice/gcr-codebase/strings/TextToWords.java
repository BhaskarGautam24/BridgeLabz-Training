/*Write a program to split the text into words, compare the result with the split() method and display the result 
Hint => 
Take user input using the Scanner nextLine() method 
Create a Method to find the length of the String without using the built-in length() method. 
Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words. Use the following logic
Firstly Count the number of words in the text and create an array to store the indexes of the spaces for each word in a 1D array
Then Create an array to store the words and use the indexes to extract the words
Create a method to compare the two String arrays and return a boolean
The main function calls the user-defined method and the built-in split() method. Call the user defined method to compare the two string arrays and display the result */

package strings;
import java.util.*;
public class TextToWords {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter a Text: ");
    String text = scn.nextLine();
    String[] wordsUsingCustomMethod = splitText(text);
    String[] wordsUsingBuiltInMethod = text.split(" ");
    boolean areEqual = compareArrays(wordsUsingCustomMethod, wordsUsingBuiltInMethod);              // Call the comparison method

    if(areEqual){
      System.out.println("The two methods produce the same result.");
    }
    else{
      System.out.println("The two methods produce different results.");
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
    String[] words = new String[wordCount];
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
