import java.util.*;
import java.util.stream.*;
class Stu{
    private String name;
    private String grade;
    Stu(String name,String grade){
        this.name=name;
        this.grade=grade;
    }
    String getName(){
        return name;
    }

    String getGrade(){
        return grade;
    }
}
public class Student{
    public static void main(String[] args){

        List<Stu> students=Arrays.asList(
            new Stu("Amit","A"),
            new Stu("Neha","B"),
            new Stu("Rahul","A")
        );
        Map<String,List<String>> result=
        students.stream()
        .collect(Collectors.groupingBy(
            Stu::getGrade,
            Collectors.mapping(Stu::getName,Collectors.toList())
        ));

        System.out.println(result);
    }
}

