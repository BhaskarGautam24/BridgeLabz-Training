package com.healthclinic.controller;

import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AppointmentController {

    private AppointmentDAO dao = new AppointmentDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments by Date");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        bookAppointment();
                        break;
                    case 2:
                        viewByDate();
                        break;
                    case 3:
                        cancelAppointment();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void bookAppointment() throws Exception {
        Appointment a = new Appointment();

        System.out.print("Patient ID: ");
        a.setPatientId(Integer.parseInt(sc.nextLine()));

        System.out.print("Doctor ID: ");
        a.setDoctorId(Integer.parseInt(sc.nextLine()));

        System.out.print("Date (yyyy-mm-dd): ");
        a.setDate(LocalDate.parse(sc.nextLine()));

        System.out.print("Time (HH:mm): ");
        a.setTime(LocalTime.parse(sc.nextLine()));

        a.setStatus("SCHEDULED");

        dao.bookAppointment(a);
        System.out.println("Appointment booked");
    }

    public void viewByDate() throws Exception {
        System.out.print("Date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        List<Appointment> list =
                dao.getAppointmentsByDate(java.sql.Date.valueOf(date));

        for (Appointment a : list) {
            System.out.println(
                    a.getAppointmentId() +
                    " Patient: " + a.getPatientId()
            );
        }
    }

    public void cancelAppointment() throws Exception {
        System.out.print("Appointment ID: ");
        int id = Integer.parseInt(sc.nextLine());

        dao.cancelAppointment(id);
        System.out.println("Appointment cancelled");
    }
}
