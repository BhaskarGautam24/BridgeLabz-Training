package com.healthclinic.dao;

import com.healthclinic.model.Specialty;
import com.healthclinic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public void addSpecialty(Specialty s) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO specialties(name) VALUES(?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.executeUpdate();

        con.close();
    }

    public List<Specialty> getAllSpecialties() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM specialties";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Specialty> list = new ArrayList<>();

        while (rs.next()) {
            Specialty s = new Specialty();
            s.setSpecialtyId(rs.getInt("specialty_id"));
            s.setName(rs.getString("name"));
            list.add(s);
        }

        con.close();
        return list;
    }

    public double getTotalRevenue() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT SUM(amount) AS total FROM bills WHERE payment_status='PAID'";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        double total = 0;
        if (rs.next()) total = rs.getDouble("total");

        con.close();
        return total;
    }
}
