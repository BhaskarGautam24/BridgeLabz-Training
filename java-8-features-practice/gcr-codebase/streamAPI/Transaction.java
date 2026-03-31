import java.time.*;
import java.util.*;
public class Transaction{
    public static void main(String[] args) {
        List<String> transactionIds = new ArrayList<String>();
        transactionIds.add("TX101");
        transactionIds.add("TX102");
        transactionIds.forEach(id ->System.out.println(LocalDateTime.now()+"-Transaction:"+id));
    }
}
