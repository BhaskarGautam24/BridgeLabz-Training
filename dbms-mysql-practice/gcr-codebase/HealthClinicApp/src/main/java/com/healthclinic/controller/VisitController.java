package com.healthclinic.controller;

import com.healthclinic.dao.VisitDAO;
import com.healthclinic.model.Visit;

import java.util.Scanner;

public class VisitController {

    private VisitDAO dao = new VisitDAO();
    private Scanner sc = new Scanner(System.in);

    public void recordVisit() throws Exception {
        Visit v = new Visit();

        System.out.print("Appointment ID: ");
        v.setAppointmentId(sc.nextInt());
        sc.nextLine();

        System.out.print("Diagnosis: ");
        v.setDiagnosis(sc.nextLine());

        System.out.print("Notes: ");
        v.setNotes(sc.nextLine());

        dao.addVisit(v);
        System.out.println("Visit recorded");
    }
}
