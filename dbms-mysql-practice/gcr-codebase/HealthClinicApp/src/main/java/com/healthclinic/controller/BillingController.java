package com.healthclinic.controller;

import com.healthclinic.dao.BillingDAO;
import com.healthclinic.dao.PaymentDAO;
import com.healthclinic.model.Bill;
import com.healthclinic.model.Payment;

import java.util.Scanner;

public class BillingController {

    private BillingDAO billingDAO = new BillingDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();
    private Scanner sc = new Scanner(System.in);

    public void generateBill() throws Exception {
        Bill b = new Bill();

        System.out.print("Visit ID: ");
        b.setVisitId(sc.nextInt());

        System.out.print("Amount: ");
        b.setAmount(sc.nextDouble());
        sc.nextLine();

        b.setPaymentStatus("UNPAID");

        billingDAO.generateBill(b);
        System.out.println("Bill generated");
    }

    public void recordPayment() throws Exception {
        Payment p = new Payment();

        System.out.print("Bill ID: ");
        p.setBillId(sc.nextInt());
        sc.nextLine();

        System.out.print("Payment Mode: ");
        p.setMode(sc.nextLine());

        paymentDAO.recordPayment(p);
        System.out.println("Payment recorded");
    }

    public void outstandingTotal() throws Exception {
        double total = billingDAO.getOutstandingTotal();
        System.out.println("Outstanding amount: " + total);
    }
}
