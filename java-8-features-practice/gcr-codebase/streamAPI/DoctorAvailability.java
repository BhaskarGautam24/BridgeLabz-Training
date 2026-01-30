import java.util.*;
public class DoctorAvailability{
    public static void main(String[] args){
        class Doctor {
            String name;
            String specialty;
            boolean weekend;
            Doctor(String name, String specialty, boolean weekend){
                this.name = name;
                this.specialty = specialty;
                this.weekend = weekend;
            }
        }
        List<Doctor> doctors = new ArrayList<Doctor>();
        doctors.add(new Doctor("Dr Arun", "Cardiology", true));
        doctors.add(new Doctor("Dr Meena", "Neurology", false));
        doctors.add(new Doctor("Dr Ravi", "Orthopedic", true));
        doctors.stream()
                .filter(d -> d.weekend == true)
                .sorted((d1, d2) -> d1.specialty.compareTo(d2.specialty))
                .forEach(d -> System.out.println(d.name + " - " + d.specialty));
    }
}
