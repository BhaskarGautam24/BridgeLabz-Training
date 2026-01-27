import java.util.*;
public class PatientIdPrint{
    public static void main(String[] args){
        ArrayList<Integer> patientIds = new ArrayList<>();
        patientIds.add(101);
        patientIds.add(102);
        patientIds.add(103);
        patientIds.add(104);
        System.out.println("Patient IDs for admin verification:");
        patientIds.forEach(System.out::println);
    }
}

