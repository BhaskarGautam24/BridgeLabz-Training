import java.util.*;
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Course<ExamCourse> examCourses = new Course<ExamCourse>();

        // creating assignment course list
        Course<AssignmentCourse> assignCourses = new Course<AssignmentCourse>();
        System.out.print("enter exam course name: ");
        String examName = scn.nextLine();
        ExamCourse ec = new ExamCourse(examName);
        // adding exam course
        examCourses.addCourse(ec);

        System.out.print("enter assignment course name: ");
        String assignName = scn.nextLine();
        AssignmentCourse ac = new AssignmentCourse(assignName);

        assignCourses.addCourse(ac);

        System.out.println("\nall university courses:");
        showCourses(examCourses.getCourses());
        showCourses(assignCourses.getCourses());
    }
    public static void showCourses(List<? extends CourseType> list) {
        for (CourseType c : list) {
            System.out.println(c.getCourseInfo());
        }
    }
}

// abstract course type
abstract class CourseType {
    private String courseName;
    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public abstract String getEvaluationType();

    public String getCourseInfo() {
        return courseName + " | evaluation: " + getEvaluationType();
    }
}

// exam based course
class ExamCourse extends CourseType {

    public ExamCourse(String courseName) {
        super(courseName);
    }

    // overriding method
    public String getEvaluationType() {
        return "exam based";
    }
}

// assignment based course
class AssignmentCourse extends CourseType {

    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    // overriding method
    public String getEvaluationType() {
        return "assignment based";
    }
}

// research based course
class ResearchCourse extends CourseType {

    public ResearchCourse(String courseName) {
        super(courseName);
    }

    // overriding method
    public String getEvaluationType() {
        return "research based";
    }
}

// generic course manager
class Course<T extends CourseType> {

    private List<T> courses;
    public Course() {
        courses = new ArrayList<T>();
    }

    // add course method
    public void addCourse(T course) {
        courses.add(course);
    }
    public List<T> getCourses() {
        return courses;
    }
}
