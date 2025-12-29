class ItemNode {

    int id;
    String name;
    int quantity;
    double price;

    ItemNode next;

    ItemNode(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
// Linked List class
class InventoryList {

    ItemNode head;
    // Add item at end
    void addItem(int id, String name, int qty, double price) {

        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }
    // Remove item by ID
    void removeItem(int id) {

        if (head == null) return;

        if (head.id == id) {
            head = head.next;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    // Update quantity
    void updateQuantity(int id, int newQty) {

        ItemNode temp = head;

        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    // Search by ID or Name
    void searchItem(int id, String name) {

        ItemNode temp = head;

        while (temp != null) {
            if (temp.id == id || temp.name.equals(name)) {
                System.out.println(temp.name + " Qty: " + temp.quantity);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found");
    }
    void totalValue() {

        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }
    void sortByName() {

        ItemNode i, j;
        for (i = head; i != null; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                if (i.name.compareTo(j.name) > 0) {

                    // Swap data
                    String n = i.name; i.name = j.name; j.name = n;
                    int q = i.quantity; i.quantity = j.quantity; j.quantity = q;
                    double p = i.price; i.price = j.price; j.price = p;
                    int id = i.id; i.id = j.id; j.id = id;
                }
            }
        }
    }
    void display() {
        ItemNode temp = head;

        while (temp != null) {
            System.out.println(temp.id + " " + temp.name +
                    " Qty:" + temp.quantity + " Price:" + temp.price);
            temp = temp.next;
        }
    }
}
public class InventoryManagement {
    public static void main(String[] args) {
        InventoryList list = new InventoryList();

        list.addItem(1, "Pen", 10, 5);
        list.addItem(2, "Book", 5, 50);
        list.addItem(3, "Pencil", 20, 2);

        list.display();
        list.updateQuantity(1, 15);
        list.searchItem(2, "");
        list.totalValue();

        list.sortByName();
        System.out.println("After Sorting:");
        list.display();
    }
}
