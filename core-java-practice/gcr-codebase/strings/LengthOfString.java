package strings;
import java.util.*;
public class LengthOfString {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int length = lengthofstring(str);
    System.out.println("Length of the string is: " + length);
    System.out.println("Length using built-in method: " + str.length());
  }

  public static int lengthofstring(String str){
    int length=0;
    while(true){
      try{
        str.charAt(length);
        length++;
      }
      catch(StringIndexOutOfBoundsException e){
        break;
      }
    }
    return length;
  }
  
}
