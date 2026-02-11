package com.healthclinic.service;

import com.healthclinic.dao.PrescriptionDAO;
import com.healthclinic.model.Prescription;

import java.util.List;

public class PrescriptionService {

    private PrescriptionDAO dao = new PrescriptionDAO();

    public void addPrescriptions(List<Prescription> list) throws Exception {
        dao.addPrescriptions(list);
    }
}
