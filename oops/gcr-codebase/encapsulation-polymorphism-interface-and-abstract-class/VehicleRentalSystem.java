import java.util.*;

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // variables
        String num, policy;
        double rate;
        int days;

        // car input
        System.out.println("enter car number:");
        num = scn.nextLine();
        System.out.println("enter rental rate per day:");
        rate = scn.nextDouble();
        scn.nextLine();
        System.out.println("enter car insurance policy:");
        policy = scn.nextLine();
        System.out.println("enter rental days:");
        days = scn.nextInt();
        scn.nextLine();

        Vehicle car = new Car(num, rate, policy);
        car.displayDetails();
        System.out.println("rental cost: " + car.calculateRentalCost(days));
        System.out.println("insurance cost: " + ((Insurable)car).calculateInsurance());
        System.out.println(((Insurable)car).getInsuranceDetails());

        // bike input
        System.out.println("\nenter bike number:");
        num = scn.nextLine();
        System.out.println("enter rental rate per day:");
        rate = scn.nextDouble();
        scn.nextLine();
        System.out.println("enter bike insurance policy:");
        policy = scn.nextLine();
        System.out.println("enter rental days:");
        days = scn.nextInt();
        scn.nextLine();

        Vehicle bike = new Bike(num, rate, policy);
        bike.displayDetails();
        System.out.println("rental cost: " + bike.calculateRentalCost(days));
        System.out.println("insurance cost: " + ((Insurable)bike).calculateInsurance());
        System.out.println(((Insurable)bike).getInsuranceDetails());

        // truck input
        System.out.println("\nenter truck number:");
        num = scn.nextLine();
        System.out.println("enter rental rate per day:");
        rate = scn.nextDouble();
        scn.nextLine();
        System.out.println("enter truck insurance policy:");
        policy = scn.nextLine();
        System.out.println("enter rental days:");
        days = scn.nextInt();

        Vehicle truck = new Truck(num, rate, policy);
        truck.displayDetails();
        System.out.println("rental cost: " + truck.calculateRentalCost(days));
        System.out.println("insurance cost: " + ((Insurable)truck).calculateInsurance());
        System.out.println(((Insurable)truck).getInsuranceDetails());

        scn.close();
    }
}

// abstract vehicle class
abstract class Vehicle implements Insurable {

    private String vehicleNumber;
    private double rentalRate;

    public Vehicle(String vehicleNumber, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("vehicle number: " + vehicleNumber);
        System.out.println("rental rate: " + rentalRate);
    }
}

// interface for insurance
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// car class
class Car extends Vehicle {
    private String policy;

    public Car(String num, double rate, String policy) {
        super(num, rate);
        this.policy = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 500; }

    @Override
    public String getInsuranceDetails() { return "car policy: " + policy; }
}

// bike class
class Bike extends Vehicle {
    private String policy;

    public Bike(String num, double rate, String policy) {
        super(num, rate);
        this.policy = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 200; }

    @Override
    public String getInsuranceDetails() { return "bike policy: " + policy; }
}

// truck class
class Truck extends Vehicle {
    private String policy;

    public Truck(String num, double rate, String policy) {
        super(num, rate);
        this.policy = policy;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() { return 1000; }

    @Override
    public String getInsuranceDetails() { return "truck policy: " + policy; }
}

