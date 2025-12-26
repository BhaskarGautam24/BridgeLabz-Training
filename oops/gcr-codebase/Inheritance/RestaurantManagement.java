import java.util.*;
public class RestaurantManagement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // variables for person
        String name;
        int id;

        // taking chef details
        System.out.println("enter chef name:");
        name = scn.nextLine();

        System.out.println("enter chef id:");
        id = scn.nextInt();
        scn.nextLine();

        // parent reference holding child object
        Person p1 = new Chef(name, id);

        // performing duties
        ((Worker)p1).performDuties();

        // taking waiter details
        System.out.println("enter waiter name:");
        name = scn.nextLine();

        System.out.println("enter waiter id:");
        id = scn.nextInt();
        scn.nextLine();

        // parent reference holding child object
        Person p2 = new Waiter(name, id);

        // performing duties
        ((Worker)p2).performDuties();
    }
}

// superclass person
class Person {

    // variables
    private String name;
    private int id;

    // constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for id
    public int getId() {
        return id;
    }
}

// interface worker
interface Worker {

    // abstract method
    void performDuties();
}

// chef class
class Chef extends Person implements Worker {

    // constructor
    public Chef(String name, int id) {
        super(name, id);
    }

    // implementation of performDuties
    @Override
    public void performDuties() {
        System.out.println(getName() + " is cooking dishes in kitchen");
    }
}

// waiter class
class Waiter extends Person implements Worker {

    // constructor
    public Waiter(String name, int id) {
        super(name, id);
    }

    // implementation of performDuties
    @Override
    public void performDuties() {
        System.out.println(getName() + " is serving customers in restaurant");
    }
}

