interface PaymentProcessor{
    void pay(double amount);
    default void refund(double amount){
        System.out.println("Refund processed of amount: "+amount);
    }
}

class PaytmProcessor implements PaymentProcessor{
    public void pay(double amount){
        System.out.println("Payment done via Paytm: "+amount);
    }
}

class CardProcessor implements PaymentProcessor{
    public void pay(double amount){
        System.out.println("Payment done via Card: "+amount);
    }
}
public class Payment{
    public static void main(String[] args){
        PaymentProcessor paytm = new PaytmProcessor();
        PaymentProcessor card = new CardProcessor();
        paytm.pay(500);
        paytm.refund(200);

        card.pay(1000);
        card.refund(300);
    }
}
