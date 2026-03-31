package reviews;
interface Payment {
    void pay();
}
abstract class Vehicle {

    abstract void start();
    void fuel() {
        System.out.println("vehicle needs fuel");
    }
}
class Car extends Vehicle {
    public void start() {
        System.out.println("car starts with key");
    }
}
class UpiPayment implements Payment {
    public void pay() {
        System.out.println("payment done using upi");
    }
}

public class InterfaceVsAbstractDemo {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
        v.fuel();
        Payment p = new UpiPayment();
        p.pay();
    }
}

