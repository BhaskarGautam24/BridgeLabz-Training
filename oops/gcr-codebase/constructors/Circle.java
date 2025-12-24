public class Circle {
    double radius;
    Circle() {
        this(1.0);   // Calls parameterized constructor
    }
    Circle(double radius) {                            
        this.radius = radius;
    }
    void displayRadius() {
        System.out.println("Radius of the circle: " + radius);
    }
    public static void main(String[] args) {
        Circle c1 = new Circle();                               
        System.out.println("Circle 1:");
        c1.displayRadius();

        // Using Parameterized Constructor
        Circle c2 = new Circle(5.5);
        System.out.println("\nCircle 2:");
        c2.displayRadius();
    }
}

