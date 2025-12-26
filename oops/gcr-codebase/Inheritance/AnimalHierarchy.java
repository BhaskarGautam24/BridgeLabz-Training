import java.util.*;

// main class to run animal program
public class AnimalHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;

        // variable for age
        int age;
        System.out.println("enter dog name:");
        name = sc.nextLine();

        System.out.println("enter dog age:");
        age = sc.nextInt();
        sc.nextLine();

        // parent reference for dog
        Animal animal1 = new Dog(name, age);

        // calling sound method
        animal1.makeSound();

        // taking cat details
        System.out.println("enter cat name:");
        name = sc.nextLine();

        System.out.println("enter cat age:");
        age = sc.nextInt();
        sc.nextLine();

        // parent reference for cat
        Animal animal2 = new Cat(name, age);

        // calling sound method
        animal2.makeSound();

        // taking bird details
        System.out.println("enter bird name:");
        name = sc.nextLine();

        System.out.println("enter bird age:");
        age = sc.nextInt();

        // parent reference for bird
        Animal animal3 = new Bird(name, age);

        // calling sound method
        animal3.makeSound();
    }
}

// parent class animal
class Animal {

    // variable for animal name
    private String name;

    // variable for animal age
    private int age;

    // constructor for animal
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // getter for age
    public int getAge() {
        return age;
    }

    // setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // method for sound
    public void makeSound() {
        System.out.println("animal makes sound");
    }
}

// dog class
class Dog extends Animal {

    // constructor for dog
    public Dog(String name, int age) {
        super(name, age);
    }

    // sound for dog
    @Override
    public void makeSound() {
        System.out.println(getName() + " says woof woof");
    }
}

// cat class
class Cat extends Animal {

    // constructor for cat
    public Cat(String name, int age) {
        super(name, age);
    }

    // sound for cat
    @Override
    public void makeSound() {
        System.out.println(getName() + " says meow meow");
    }
}

// bird class
class Bird extends Animal {

    // constructor for bird
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(getName() + " says tweet tweet");
    }
}
