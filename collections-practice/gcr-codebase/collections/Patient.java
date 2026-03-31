import java.util.*;

public class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
class HospitalTriageSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // PriorityQueue with custom comparison
        PriorityQueue<Patient> pq = new PriorityQueue<Patient>(
            new Comparator<Patient>() {
                public int compare(Patient p1, Patient p2) {
                    return p2.severity - p1.severity; // higher first
                }
            }
        );
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Patient Name: ");
            String name = sc.next();

            System.out.print("Severity Level: ");
            int sev = sc.nextInt();

            pq.add(new Patient(name, sev));
        }
        System.out.println("\nTreatment Order:");

        while (!pq.isEmpty()) {
            Patient p = pq.remove();
            System.out.println(p.name);
        }
    }
}

