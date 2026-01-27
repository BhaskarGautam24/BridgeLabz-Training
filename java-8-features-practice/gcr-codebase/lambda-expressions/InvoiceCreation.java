import java.util.*;
import java.util.stream.Collectors;
class Invoice{
    int transactionId;
    Invoice(int transactionId){
        this.transactionId = transactionId;
    }
    public String toString(){
        return "Invoice created for Transaction ID: " + transactionId;
    }
}
public class InvoiceCreation{
    public static void main(String[] args){
        ArrayList<Integer> transactionIds = new ArrayList<>();
        transactionIds.add(501);
        transactionIds.add(502);
        transactionIds.add(503);
        transactionIds.add(504);
        List<Invoice> invoices =transactionIds.stream().map(Invoice::new).collect(Collectors.toList());
        System.out.println("Generated Invoices:");
        invoices.forEach(System.out::println);
    }
}

