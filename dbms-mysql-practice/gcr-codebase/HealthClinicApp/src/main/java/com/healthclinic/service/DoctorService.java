package com.healthclinic.service;

import com.healthclinic.dao.DoctorDAO;
import com.healthclinic.model.Doctor;

import java.util.List;

public class DoctorService {

    private DoctorDAO dao = new DoctorDAO();

    public void addDoctor(Doctor d) throws Exception {
        dao.addDoctor(d);
    }

    public List<Doctor> getAllDoctors() throws Exception {
        return dao.getAllDoctors();
    }

    public void deactivateDoctor(int id) throws Exception {
        dao.deactivateDoctor(id);
    }
}
