package com.healthclinic.service;

import com.healthclinic.dao.AdminDAO;
import com.healthclinic.model.Specialty;

import java.util.List;

public class AdminService {

    private AdminDAO dao = new AdminDAO();

    public void addSpecialty(Specialty s) throws Exception {
        dao.addSpecialty(s);
    }

    public List<Specialty> getAllSpecialties() throws Exception {
        return dao.getAllSpecialties();
    }

    public double getTotalRevenue() throws Exception {
        return dao.getTotalRevenue();
    }
}
