package com.healthclinic.controller;

import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PatientController {

    private PatientDAO dao = new PatientDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        registerPatient();
                        break;
                    case 2:
                        viewPatients();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void registerPatient() throws Exception {
        Patient p = new Patient();

        System.out.print("Name: ");
        p.setName(sc.nextLine());

        System.out.print("DOB (yyyy-mm-dd): ");
        p.setDob(LocalDate.parse(sc.nextLine()));

        System.out.print("Contact: ");
        p.setContact(sc.nextLine());

        System.out.print("Address: ");
        p.setAddress(sc.nextLine());

        System.out.print("Blood Group: ");
        p.setBloodGroup(sc.nextLine());

        dao.addPatient(p);
        System.out.println("Patient registered");
    }

    public void viewPatients() throws Exception {
        List<Patient> list = dao.getAllPatients();

        for (Patient p : list) {
            System.out.println(p.getPatientId() + " " + p.getName());
        }
    }
}
