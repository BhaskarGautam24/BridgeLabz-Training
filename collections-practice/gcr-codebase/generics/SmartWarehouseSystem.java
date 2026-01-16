import java.util.*;
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // creating storage for electronics
        Storage<Electronics> elecStorage = new Storage<Electronics>();
        Storage<Groceries> grocStorage = new Storage<Groceries>();
        System.out.print("enter electronics name: ");
        String eName = scn.nextLine();
        Electronics eItem = new Electronics(eName);

        elecStorage.addItem(eItem);

        System.out.print("enter grocery name: ");
        String gName = scn.nextLine();
        Groceries gItem = new Groceries(gName);

        grocStorage.addItem(gItem);

        System.out.println("\nwarehouse items are:");
        displayItems(elecStorage.getItems());
        displayItems(grocStorage.getItems());
    }
    // wildcard method to display items
    public static void displayItems(List<? extends WarehouseItem> list) {

        for (WarehouseItem item : list) {
            System.out.println(item.getDetails());
        }
    }
}
abstract class WarehouseItem {

    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

 
    public void setName(String name) {
        this.name = name;
    }

    // abstract method
    public abstract String getDetails();

    public String commonInfo() {
        return "stored in warehouse";
    }
}

// electronics child class
class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    // overriding method
    public String getDetails() {
        String info = "electronics item: " + getName();
        return info;
    }
}

// groceries child class
class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    // overriding method
    public String getDetails() {
        String info = "grocery item: " + getName();
        return info;
    }
}

// furniture child class
class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    // overriding method
    public String getDetails() {
        String info = "furniture item: " + getName();
        return info;
    }
}

// generic storage class
class Storage<T extends WarehouseItem> {

    private List<T> items;

    public Storage() {
        items = new ArrayList<T>();
    }

    // add item method
    public void addItem(T item) {
        items.add(item);
    }

    // getter for items
    public List<T> getItems() {
        return items;
    }
}

