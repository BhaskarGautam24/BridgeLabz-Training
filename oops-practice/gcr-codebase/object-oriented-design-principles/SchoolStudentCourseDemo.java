import java.util.*;
public class SchoolStudentCourseDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

      
        System.out.print("enter school name: ");
        String schoolName = scn.nextLine();

        // creating school object
        School school = new School(schoolName);

      
        System.out.print("enter student name: ");
        String studentName = scn.nextLine();

        // creating student object
        Student student = new Student(studentName);
        // adding student to school
        school.addStudent(student);
        
        System.out.print("enter first course name: ");
        String courseOneName = scn.nextLine();

        System.out.print("enter second course name: ");
        String courseTwoName = scn.nextLine();

        // creating course objects
        Course courseOne = new Course(courseOneName);
        Course courseTwo = new Course(courseTwoName);

        // enrolling student into courses
        student.enrollCourse(courseOne);
        student.enrollCourse(courseTwo);

        // showing student courses
        student.showCourses();

        // showing students in course
        courseOne.showStudents();
        courseTwo.showStudents();
    }
}
class School {
    private String schoolName;

    // list to store students
    private ArrayList<Student> studentList;

    // constructor for school
    public School(String schoolName) {
        // assigning school name
        this.schoolName = schoolName;
        // creating student list
        this.studentList = new ArrayList<Student>();
    }

    // method to add student
    public void addStudent(Student student) {
        // adding student into school
        studentList.add(student);
    }

    // getter for school name
    public String getSchoolName() {
        return schoolName;
    }
}
class Student {

    // student name variable
    private String studentName;

    // list to store courses
    private ArrayList<Course> courseList;

    // constructor for student
    public Student(String studentName) {
        // assigning student name
        this.studentName = studentName;
        // creating course list
        this.courseList = new ArrayList<Course>();
    }

    // method to enroll course
    public void enrollCourse(Course course) {
        // adding course to student
        courseList.add(course);
        // adding student to course
        course.addStudent(this);
    }

    // method to show courses
    public void showCourses() {
        // printing student name
        System.out.println("\nstudent name: " + studentName);
        System.out.println("enrolled courses:");

        // loop for courses
        for (int i = 0; i < courseList.size(); i++) {
            // getting course object
            Course tempCourse = courseList.get(i);
            // printing course name
            System.out.println("- " + tempCourse.getCourseName());
        }
    }

    // getter for student name
    public String getStudentName() {
        return studentName;
    }
}
class Course {

    // course name variable
    private String courseName;

    // list to store students
    private ArrayList<Student> studentList;

    // constructor for course
    public Course(String courseName) {
        // assigning course name
        this.courseName = courseName;
        // creating student list
        this.studentList = new ArrayList<Student>();
    }

    // method to add student
    public void addStudent(Student student) {
        // adding student into course
        studentList.add(student);
    }

    // method to show students
    public void showStudents() {
        // printing course name
        System.out.println("\ncourse name: " + courseName);
        System.out.println("enrolled students:");
        for (int i = 0; i < studentList.size(); i++) {
            // getting student object
            Student tempStudent = studentList.get(i);
            
            System.out.println("- " + tempStudent.getStudentName());
        }
    }
    // getter for course name
    public String getCourseName() {
        return courseName;
    }
}

