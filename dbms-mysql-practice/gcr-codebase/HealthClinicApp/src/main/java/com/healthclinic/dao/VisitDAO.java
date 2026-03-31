package com.healthclinic.dao;

import com.healthclinic.model.Visit;
import com.healthclinic.util.DBConnection;

import java.sql.*;

public class VisitDAO {

    public void addVisit(Visit v) throws Exception {
        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        String visitSql = "INSERT INTO visits(appointment_id,diagnosis,notes) VALUES(?,?,?)";
        PreparedStatement ps1 = con.prepareStatement(visitSql);
        ps1.setInt(1, v.getAppointmentId());
        ps1.setString(2, v.getDiagnosis());
        ps1.setString(3, v.getNotes());
        ps1.executeUpdate();

        String updateSql = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";
        PreparedStatement ps2 = con.prepareStatement(updateSql);
        ps2.setInt(1, v.getAppointmentId());
        ps2.executeUpdate();

        con.commit();
        con.close();
    }
}
