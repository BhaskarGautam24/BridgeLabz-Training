import java.time.*;
import java.util.*;
public class Gym{
    public static void main(String[] args){
        class Member {
            String name;
            LocalDate expiry;
            Member(String name, LocalDate expiry){
                this.name = name;
                this.expiry = expiry;
            }
        }
        List<Member> members = new ArrayList<Member>();
        members.add(new Member("Rahul", LocalDate.now().plusDays(10)));
        members.add(new Member("Amit", LocalDate.now().plusDays(40)));
        members.add(new Member("Neha", LocalDate.now().plusDays(25)));
        members.stream()
                .filter(m -> m.expiry.isBefore(LocalDate.now().plusDays(30)))
                .forEach(m -> System.out.println(m.name + " membership expiring soon"));
    }
}

