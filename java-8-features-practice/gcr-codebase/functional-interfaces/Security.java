interface SensitiveData{
}
class BankAccount implements SensitiveData{
    String accountNumber;
    BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }
}
public class Security{
    public static void main(String[] args){
        BankAccount account = new BankAccount("1234-5678");
        if (account instanceof SensitiveData){
            System.out.println("Encrypt this data before storing");
        } else {
            System.out.println("No encryption needed");
        }
    }
}
