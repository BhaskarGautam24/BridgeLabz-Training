import java.util.*;
public class CourseHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int duration;
        String platform;
        boolean recorded;
        double fee;
        double discount;

        System.out.println("enter course name:");
        name = sc.nextLine();

        System.out.println("enter duration:");
        duration = sc.nextInt();
        sc.nextLine();

        System.out.println("enter platform:");
        platform = sc.nextLine();

        System.out.println("is recorded true/false:");
        recorded = sc.nextBoolean();

        System.out.println("enter fee:");
        fee = sc.nextDouble();

        System.out.println("enter discount:");
        discount = sc.nextDouble();

        // parent reference usage
        Course course = new PaidOnlineCourse(
                name, duration, platform, recorded, fee, discount
        );

        // showing details
        course.displayInfo();
    }
}

// base course class
class Course {

    // variables
    private String courseName;
    private int duration;

    // constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // method to show info
    public void displayInfo() {
        System.out.println("course: " + courseName);
        System.out.println("duration: " + duration);
    }
}

// online course class
class OnlineCourse extends Course {

    // variables
    private String platform;
    private boolean recorded;

    // constructor
    public OnlineCourse(String name, int duration, String platform, boolean recorded) {
        super(name, duration);
        this.platform = platform;
        this.recorded = recorded;
    }

    // overriding method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("platform: " + platform);
        System.out.println("recorded: " + recorded);
    }
}

// paid online course class
class PaidOnlineCourse extends OnlineCourse {

    // variables
    private double fee;
    private double discount;

    // constructor
    public PaidOnlineCourse(
            String name,
            int duration,
            String platform,
            boolean recorded,
            double fee,
            double discount
    ) {
        super(name, duration, platform, recorded);
        this.fee = fee;
        this.discount = discount;
    }

    // overriding method
    @Override
    public void displayInfo() {
        super.displayInfo();
        double finalAmount = fee - discount;
        System.out.println("final fee: " + finalAmount);
    }
}

