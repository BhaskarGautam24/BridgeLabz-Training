class Chef extends Thread {
    String chefName;
    String dishName;
    int totalTime;  
    Chef(String chefName, String dishName, int totalTime) {
        this.chefName = chefName;
        this.dishName = dishName;
        this.totalTime = totalTime;
    }
    public void run() {

        System.out.println(chefName + " started preparing " + dishName);

        int stepTime = totalTime / 4;
        try {
            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dishName + ": 25% complete");

            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dishName + ": 50% complete");

            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dishName + ": 75% complete");

            Thread.sleep(stepTime);
            System.out.println(chefName + " preparing " + dishName + ": 100% complete");

        } catch (InterruptedException e) {
            System.out.println("Cooking interrupted");
        }
    }
}
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef c1 = new Chef("Chef-1", "Pizza", 3000);
        Chef c2 = new Chef("Chef-2", "Pasta", 2000);
        Chef c3 = new Chef("Chef-3", "Salad", 1000);
        Chef c4 = new Chef("Chef-4", "Burger", 2500);
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException e) {
            System.out.println("Manager interrupted");
        }
        System.out.println("Kitchen closed - All orders completed");
    }
}
