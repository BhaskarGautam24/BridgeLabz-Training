package com.healthclinic.dao;

import com.healthclinic.model.Prescription;
import com.healthclinic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PrescriptionDAO {

    public void addPrescriptions(List<Prescription> list) throws Exception {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO prescriptions(visit_id,medicine,dosage,duration) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        for (Prescription p : list) {
            ps.setInt(1, p.getVisitId());
            ps.setString(2, p.getMedicine());
            ps.setString(3, p.getDosage());
            ps.setString(4, p.getDuration());
            ps.addBatch();
        }

        ps.executeBatch();
        con.close();
    }
}
