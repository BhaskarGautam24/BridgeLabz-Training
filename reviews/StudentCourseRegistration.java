package reviews;

import java.util.*;
class Person {
    private String name;
    private int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String getName() {
        return name;
    }
}

abstract class RegistrationService {
    abstract void enroll(Student s, String course) throws CourseLimitExceededException;
    void welcome() {
        System.out.println("welcome");
    }
}

class CourseLimitExceededException extends Exception {
    CourseLimitExceededException(String msg) {
        super(msg);
    }
}
class Student extends Person {

    private int id;
    private LinkedList<String> courses = new LinkedList<>();
    private HashMap<String, Integer> grades = new HashMap<>();
    final int MAX = 3;

    Student(int id, String name, int age) {
        super(name, age);
        this.id = id;
    }

    int getId() {
        return id;
    }

    void addCourse(String c) throws CourseLimitExceededException {
        if (courses.size() >= MAX)
            throw new CourseLimitExceededException("course limit over");
        courses.add(c);
    }

    void dropCourse(String c) {
        courses.remove(c);
        grades.remove(c);
    }

    void setGrade(String c, int g) {
        if (courses.contains(c))
            grades.put(c, g);
    }
    LinkedList<String> getCourses() {
        return courses;
    }

    HashMap<String, Integer> getGrades() {
        return grades;
    }
}
class StudentService extends RegistrationService {
    void enroll(Student s, String course) throws CourseLimitExceededException {
        s.addCourse(course);
        System.out.println(course + " added");
    }
}
public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Student> map = new HashMap<>();
        StudentService service = new StudentService();
        service.welcome();

        int id = 1;
        boolean run = true;

        while (run) {
            System.out.println("1.register 2.enroll 3.drop 4.grade 5.show 6.exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                System.out.println("name:");
                String name = sc.nextLine();
                System.out.println("age:");
                int age = sc.nextInt();
                sc.nextLine();
                Student s = new Student(id, name, age);
                map.put(id, s);
                System.out.println("student id: " + id);
                id++;
            }

            else if (ch == 2) {
                System.out.println("id:");
                int sid = sc.nextInt();
                sc.nextLine();
                Student s = map.get(sid);
                if (s != null) {
                    System.out.println("course:");
                    String c = sc.nextLine();
                    try {
                        service.enroll(s, c);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            else if (ch == 3) {
                System.out.println("id:");
                int sid = sc.nextInt();
                sc.nextLine();
                Student s = map.get(sid);
                if (s != null) {
                    System.out.println("course:");
                    String c = sc.nextLine();
                    s.dropCourse(c);
                }
            }

            else if (ch == 4) {
                System.out.println("id:");
                int sid = sc.nextInt();
                sc.nextLine();
                Student s = map.get(sid);
                if (s != null) {
                    System.out.println("course:");
                    String c = sc.nextLine();
                    System.out.println("grade:");
                    int g = sc.nextInt();
                    sc.nextLine();
                    s.setGrade(c, g);
                }
            }

            else if (ch == 5) {
                System.out.println("id:");
                int sid = sc.nextInt();
                sc.nextLine();
                Student s = map.get(sid);
                if (s != null) {
                    System.out.println("courses: " + s.getCourses());
                    System.out.println("grades: " + s.getGrades());
                }
            }

            else if (ch == 6) {
                run = false;
                
            }
        }
        System.out.println("Thank you");
    }
}
