import java.util.*;
public class LexicalTwist {
    public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
       String str = scn.nextLine();
       String str1 = scn.nextLine();
       StringBuilder sb = new StringBuilder(str);
        StringBuilder sb1 = new StringBuilder(str1);
        if(sb1.reverse().toString().equals(sb.toString())){
            System.out.println("The given strings are lexical twist of each other:" + reverse(sb.toString(),sb1.toString()));
        }
        else{
        System.out.println("The given strings are not lexical twist of each other:" + notreverse(sb.toString()+sb1.toString()));
        }
       

    }
    public static String reverse(String str,String str1){
            StringBuilder sb = new StringBuilder(str);
        StringBuilder sb1 = new StringBuilder(str1);
            sb.reverse().toString().toLowerCase();
            for(int i=0;i<sb.length();i++){
                char ch = sb.charAt(i);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    sb.setCharAt(i, '@');
                }                           
            }          
        
        return sb.toString();
    }  
    public static String notreverse(String str){
      StringBuilder sb = new StringBuilder();
        String store = str.toUpperCase();
        int count=0;
        int count1=0;
        for(int i=0;i<store.length();i++){
            char ch = store.charAt(i);
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                count++;
            } 
            else{
                count1++;
            }                          
        }
        if(count>count1){
             for (int i = 0; i < store.length(); i++) {

            char ch = store.charAt(i);

            if ((ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
                    && sb.indexOf(ch + "") == -1) {

                sb.append(ch);
            }

            if (sb.length() == 2) {
                return sb.toString();
            }
        }
            
        }
        else if(count1>count){
           for (int i = 0; i < store.length(); i++) {

            char ch = store.charAt(i);

            if ((ch!='A'&& ch!='E'&& ch!='I'&&ch!='O'&& ch!='U')
                    && sb.indexOf(ch + "") == -1) {

                sb.append(ch);
            }
            if (sb.length() == 2) {
                return sb.toString();
            }
        }
        }  
    return "Vowel And Consoonant Are Equal";
  }
}