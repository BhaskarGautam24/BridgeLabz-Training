class Employee {
     // Instance (non-static) variables to store employee data
	String name;
	int id;
	double salary;
	
	// Parameterized constructor to initialize employee details
	Employee(String name, int id, double salary) {
		// 'this' keyword is used to differentiate instance variables from parameters
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public void displayEmployee() {
		System.out.println("Employee Name: " + name);
		System.out.println("Employee id: " + id);
		System.out.println("Employee Salary: " + salary);
	}
	public static void main(String[] args) {		
		// Creating Employee object and passing values using constructor
		Employee emp = new Employee("Rohan", 1, 5000);
		emp.displayEmployee();
	}
}

