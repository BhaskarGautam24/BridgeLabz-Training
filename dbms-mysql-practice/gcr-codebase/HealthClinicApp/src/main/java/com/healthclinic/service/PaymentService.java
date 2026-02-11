package com.healthclinic.service;

import com.healthclinic.dao.PaymentDAO;
import com.healthclinic.model.Payment;

public class PaymentService {

    private PaymentDAO dao = new PaymentDAO();

    public void recordPayment(Payment p) throws Exception {
        dao.recordPayment(p);
    }
}