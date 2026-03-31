package com.healthclinic.service;

import com.healthclinic.dao.PatientDAO;
import com.healthclinic.model.Patient;

import java.util.List;

public class PatientService {

    private PatientDAO dao = new PatientDAO();

    public void registerPatient(Patient p) throws Exception {
        dao.addPatient(p);
    }

    public List<Patient> getAllPatients() throws Exception {
        return dao.getAllPatients();
    }

    public void updatePatient(Patient p) throws Exception {
        dao.updatePatient(p);
    }

    public void deletePatient(int id) throws Exception {
        dao.deletePatient(id);
    }
}
