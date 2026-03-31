package com.healthclinic.controller;

import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.model.Doctor;

import java.util.List;
import java.util.Scanner;

public class DoctorController {

    private DoctorDAO dao = new DoctorDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        viewDoctors();
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

    public void addDoctor() throws Exception {
        Doctor d = new Doctor();

        System.out.print("Name: ");
        d.setName(sc.nextLine());

        System.out.print("Specialty ID: ");
        d.setSpecialtyId(Integer.parseInt(sc.nextLine()));

        System.out.print("Contact: ");
        d.setContact(sc.nextLine());

        System.out.print("Consultation Fee: ");
        d.setConsultationFee(Double.parseDouble(sc.nextLine()));

        d.setActive(true);

        dao.addDoctor(d);
        System.out.println("Doctor added");
    }

    public void viewDoctors() throws Exception {
        List<Doctor> list = dao.getAllDoctors();

        for (Doctor d : list) {
            System.out.println(d.getDoctorId() + " " + d.getName());
        }
    }
}
