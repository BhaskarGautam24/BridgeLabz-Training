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