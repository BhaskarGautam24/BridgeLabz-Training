class Circle {
	double radius;
	// Constructor to initialize radius
	Circle(double radius) {
		this.radius = radius;
	}
	public double calculateArea() {
		return Math.PI * radius * radius;
	}	
	// Method to calculate circumference of the circle
	public double calculateCircumference() {
		return 2 * Math.PI * radius;
	}
	public void displayCircleDetails() {
		System.out.println("Area of Circle: " + calculateArea());
		System.out.println("Circumference of Circle: " + calculateCircumference());
	}
	public static void main(String[] args) {
		
		// Creating Circle object and passing radius
		Circle circle = new Circle(2.5);
		circle.displayCircleDetails();
	}
}
