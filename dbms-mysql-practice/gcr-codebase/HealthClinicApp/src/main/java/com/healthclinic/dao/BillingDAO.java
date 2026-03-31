package com.healthclinic.dao;

import com.healthclinic.model.Bill;
import com.healthclinic.util.DBConnection;

import java.sql.*;

public class BillingDAO {

    public void generateBill(Bill b) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO bills(visit_id,amount,payment_status) VALUES(?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, b.getVisitId());
        ps.setDouble(2, b.getAmount());
        ps.setString(3, b.getPaymentStatus());

        ps.executeUpdate();
        con.close();
    }

    public double getOutstandingTotal() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT SUM(amount) AS total FROM bills WHERE payment_status='UNPAID'";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        double total = 0;
        if (rs.next()) total = rs.getDouble("total");

        con.close();
        return total;
    }
}
