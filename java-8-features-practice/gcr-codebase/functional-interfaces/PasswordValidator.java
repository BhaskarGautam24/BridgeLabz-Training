interface SecurityUtils{
    static boolean checkPasswordStrength(String password){
        if (password.length() < 8){
            return false;
        }
        boolean hasDigit=false;
        boolean hasUpper=false;
        for (int i=0;i<password.length();i++){
            char ch=password.charAt(i);
            if (Character.isDigit(ch)){
                hasDigit=true;
            }
            if (Character.isUpperCase(ch)){
                hasUpper=true;
            } 
        }
        return hasDigit && hasUpper;
    }
}
public class PasswordValidator{
    public static void main(String[] args){
        String password="Bhaskar123";

        if (SecurityUtils.checkPasswordStrength(password)){
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}

