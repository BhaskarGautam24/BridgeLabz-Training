package com.healthclinic.controller;

import com.healthclinic.dao.AdminDAO;
import com.healthclinic.model.Specialty;

import java.util.List;
import java.util.Scanner;

public class AdminController {

    private AdminDAO dao = new AdminDAO();
    private Scanner sc = new Scanner(System.in);

    public void addSpecialty() throws Exception {
        Specialty s = new Specialty();

        System.out.print("Specialty name: ");
        s.setName(sc.nextLine());

        dao.addSpecialty(s);
        System.out.println("Specialty added");
    }

    public void viewSpecialties() throws Exception {
        List<Specialty> list = dao.getAllSpecialties();

        for (Specialty s : list) {
            System.out.println(s.getSpecialtyId() + " " + s.getName());
        }
    }

    public void revenueReport() throws Exception {
        double total = dao.getTotalRevenue();
        System.out.println("Total revenue: " + total);
    }
}
