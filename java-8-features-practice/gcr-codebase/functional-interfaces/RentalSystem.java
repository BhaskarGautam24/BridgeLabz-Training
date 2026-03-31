interface Vehicle{
    void rent();
    void returnVehicle();
}
class Car implements Vehicle{
    public void rent() {
        System.out.println("Car is rented now");
    }

    public void returnVehicle(){
        System.out.println("Car is returned successfully");
    }
}

class Bike implements Vehicle{

    public void rent(){
        System.out.println("Bike is rented now");
    }

    public void returnVehicle(){
        System.out.println("Bike is returned successfully");
    }
}

class Bus implements Vehicle{

    public void rent(){
        System.out.println("Bus is rented now");
    }

    public void returnVehicle(){
        System.out.println("Bus is returned successfully");
    }
}

public class RentalSystem{
    public static void main(String[] args){

        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus();
        car.rent();
        car.returnVehicle();
        bike.rent();
        bike.returnVehicle();
        bus.rent();
        bus.returnVehicle();
    }
}

