/*Write a program to demonstrate NullPointerException. 
Hint => 
Write a Method to generate the Exception. Here define the variable text and initialize it to null. Then call one of the String Method to generate the exception
Write the Method to demonstrate NullPointerException. Here define the variable text and initialize it to null. Then write try catch block for handling the Exception while accessing one of the String method
From the main Firstly call the method to generate the Exception then refactor the code to call the method to handle the RuntimeException
 */
package strings;
public class NullPointerException {
    public static void main(String[] args) {
       
        try {                                               // Method to generate NullPointerException
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        
        handleNullPointerException();
    }

    
    public static void generateNullPointerException() {
        String text = null;
      
        System.out.println(text.length());                        // This will throw NullPointerException
    }

    
    public static void handleNullPointerException() {           // Method to handle NullPointerException
        String text = null;
        try {
            
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException: The string is null.");
        }
    }
}