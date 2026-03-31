package com.healthclinic.dao;

import com.healthclinic.model.Payment;
import com.healthclinic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    public void recordPayment(Payment p) throws Exception {
        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        String updateBill = "UPDATE bills SET payment_status='PAID' WHERE bill_id=?";
        PreparedStatement ps1 = con.prepareStatement(updateBill);
        ps1.setInt(1, p.getBillId());
        ps1.executeUpdate();

        String insertPay = "INSERT INTO payments(bill_id,mode) VALUES(?,?)";
        PreparedStatement ps2 = con.prepareStatement(insertPay);
        ps2.setInt(1, p.getBillId());
        ps2.setString(2, p.getMode());
        ps2.executeUpdate();

        con.commit();
        con.close();
    }
}
