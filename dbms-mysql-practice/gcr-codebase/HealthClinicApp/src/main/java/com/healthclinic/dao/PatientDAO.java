package com.healthclinic.dao;

import com.healthclinic.model.Patient;
import com.healthclinic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public void addPatient(Patient p) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO patients(name,dob,contact,address,blood_group) VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setDate(2, Date.valueOf(p.getDob()));
        ps.setString(3, p.getContact());
        ps.setString(4, p.getAddress());
        ps.setString(5, p.getBloodGroup());

        ps.executeUpdate();
        con.close();
    }

    public List<Patient> getAllPatients() throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM patients";

        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Patient> list = new ArrayList<>();

        while (rs.next()) {
            Patient p = new Patient();
            p.setPatientId(rs.getInt("patient_id"));
            p.setName(rs.getString("name"));
            list.add(p);
        }

        con.close();
        return list;
    }

    public void updatePatient(Patient p) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE patients SET name=?,contact=?,address=? WHERE patient_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setString(2, p.getContact());
        ps.setString(3, p.getAddress());
        ps.setInt(4, p.getPatientId());

        ps.executeUpdate();
        con.close();
    }

    public void deletePatient(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM patients WHERE patient_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        con.close();
    }
}
