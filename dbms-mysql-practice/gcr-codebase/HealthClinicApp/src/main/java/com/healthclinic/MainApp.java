package com.healthclinic;

import java.util.Scanner;
import com.healthclinic.controller.PatientController;
import com.healthclinic.controller.DoctorController;
import com.healthclinic.controller.AppointmentController;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();
        AppointmentController appointmentController = new AppointmentController();

        while (true) {
            System.out.println("\n=== Health Clinic Management System ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    patientController.menu();
                    break;

                case 2:
                    doctorController.menu();
                    break;

                case 3:
                    appointmentController.menu();
                    break;

                case 4:
                    System.out.println("Exiting application");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
