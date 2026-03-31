package com.healthclinic.dao;

import com.healthclinic.model.Appointment;
import com.healthclinic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    public void bookAppointment(Appointment a) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, a.getPatientId());
        ps.setInt(2, a.getDoctorId());
        ps.setDate(3, Date.valueOf(a.getDate()));
        ps.setTime(4, Time.valueOf(a.getTime()));
        ps.setString(5, a.getStatus());

        ps.executeUpdate();
        con.close();
    }

    public List<Appointment> getAppointmentsByDate(Date date) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM appointments WHERE appointment_date=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, date);
        ResultSet rs = ps.executeQuery();

        List<Appointment> list = new ArrayList<>();

        while (rs.next()) {
            Appointment a = new Appointment();
            a.setAppointmentId(rs.getInt("appointment_id"));
            a.setPatientId(rs.getInt("patient_id"));
            list.add(a);
        }

        con.close();
        return list;
    }

    public void cancelAppointment(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        con.close();
    }
}
