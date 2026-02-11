package com.healthclinic.dao;

import com.healthclinic.model.Doctor;
import com.healthclinic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public void addDoctor(Doctor d) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO doctors(name,specialty_id,contact,consultation_fee,is_active) VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, d.getName());
        ps.setInt(2, d.getSpecialtyId());
        ps.setString(3, d.getContact());
        ps.setDouble(4, d.getConsultationFee());
        ps.setBoolean(5, d.isActive());

        ps.executeUpdate();
        con.close();
    }

    public List<Doctor> getAllDoctors() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM doctors";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Doctor> list = new ArrayList<>();

        while (rs.next()) {
            Doctor d = new Doctor();
            d.setDoctorId(rs.getInt("doctor_id"));
            d.setName(rs.getString("name"));
            list.add(d);
        }

        con.close();
        return list;
    }

    public void deactivateDoctor(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE doctors SET is_active=false WHERE doctor_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        con.close();
    }
}
