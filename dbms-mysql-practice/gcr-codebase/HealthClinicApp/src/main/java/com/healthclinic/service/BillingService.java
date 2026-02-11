package com.healthclinic.service;

import com.healthclinic.dao.BillingDAO;
import com.healthclinic.model.Bill;

public class BillingService {

    private BillingDAO dao = new BillingDAO();

    public void generateBill(Bill b) throws Exception {
        dao.generateBill(b);
    }

    public double getOutstandingTotal() throws Exception {
        return dao.getOutstandingTotal();
    }
}
