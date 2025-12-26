import java.util.*;
public class HospitalConsultationDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter hospital name: ");
        String hospitalName = scn.nextLine();

        // creating hospital object
        Hospital hospital = new Hospital(hospitalName);
        System.out.print("enter doctor name: ");
        String doctorName = scn.nextLine();
        System.out.print("enter patient name: ");
        String patientName = scn.nextLine();

        // creating doctor and patient objects
        Doctor doctor = new Doctor(doctorName);
        Patient patient = new Patient(patientName);

        // adding doctor and patient to hospital
        hospital.addDoctor(doctor);
        hospital.addPatient(patient);

        // doctor consulting patient
        doctor.consult(patient);

        // showing consultation history
        doctor.showPatients();
        patient.showDoctors();
    }
}
class Hospital {
    // hospital name variable
    private String hospitalName;

    // list to store doctors
    private ArrayList<Doctor> doctorList;

    // list to store patients
    private ArrayList<Patient> patientList;

    // constructor for hospital
    public Hospital(String hospitalName) {
        // assigning hospital name
        this.hospitalName = hospitalName;
        // creating doctor list
        this.doctorList = new ArrayList<Doctor>();
        // creating patient list
        this.patientList = new ArrayList<Patient>();
    }

    // method to add doctor
    public void addDoctor(Doctor doctor) {
        // adding doctor to hospital
        doctorList.add(doctor);
    }

    // method to add patient
    public void addPatient(Patient patient) {
        // adding patient to hospital
        patientList.add(patient);
    }
}
class Doctor {

    // doctor name variable
    private String doctorName;

    // list to store patients
    private ArrayList<Patient> patientList;

    // constructor for doctor
    public Doctor(String doctorName) {
        // assigning doctor name
        this.doctorName = doctorName;
        // creating patient list
        this.patientList = new ArrayList<Patient>();
    }

    // method for consultation
    public void consult(Patient patient) {
        // adding patient to doctor list
        patientList.add(patient);
        // adding doctor to patient list
        patient.addDoctor(this);

        // showing consultation message
        System.out.println("\nconsultation done:");
        System.out.println("doctor " + doctorName + " checked patient " + patient.getPatientName());
    }

    // method to show patients
    public void showPatients() {
        // printing doctor name
        System.out.println("\ndoctor: " + doctorName);
        System.out.println("patients consulted:");

        // loop for patients
        for (int i = 0; i < patientList.size(); i++) {
            // getting patient object
            Patient tempPatient = patientList.get(i);
            // printing patient name
            System.out.println("- " + tempPatient.getPatientName());
        }
    }

    // getter for doctor name
    public String getDoctorName() {
        return doctorName;
    }
}
class Patient {
    private String patientName;

    // list to store doctors
    private ArrayList<Doctor> doctorList;

    // constructor for patient
    public Patient(String patientName) {
        // assigning patient name
        this.patientName = patientName;
        // creating doctor list
        this.doctorList = new ArrayList<Doctor>();
    }

    // method to add doctor
    public void addDoctor(Doctor doctor) {
        // adding doctor to list
        doctorList.add(doctor);
    }

    // method to show doctors
    public void showDoctors() {
        // printing patient name
        System.out.println("\npatient: " + patientName);
        System.out.println("doctors consulted:");

        // loop for doctors
        for (int i = 0; i < doctorList.size(); i++) {
            // getting doctor object
            Doctor tempDoctor = doctorList.get(i);
            // printing doctor name
            System.out.println("- " + tempDoctor.getDoctorName());
        }
    }

    // getter for patient name
    public String getPatientName() {
        return patientName;
    }
}
