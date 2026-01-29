interface Payment{

    void pay();
}

class UPI implements Payment{

    public void pay() {
        System.out.println("Payment done using UPI");
    }
}

class CreditCard implements Payment {
    public void pay() {
        System.out.println("Payment done using Credit Card");
    }
}

class Wallet implements Payment{

    public void pay() {
        System.out.println("Payment done using Wallet");
    }
}

public class PaymentSystem{
    public static void main(String[] args){

        Payment upi = new UPI();
        Payment card = new CreditCard();
        Payment wallet = new Wallet();

        upi.pay();
        card.pay();
        wallet.pay();
    }
}

