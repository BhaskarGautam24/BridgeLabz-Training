package com.healthclinic.service;

import com.healthclinic.dao.AppointmentDAO;
import com.healthclinic.model.Appointment;

import java.sql.Date;
import java.util.List;

public class AppointmentService {

    private AppointmentDAO dao = new AppointmentDAO();

    public void bookAppointment(Appointment a) throws Exception {
        dao.bookAppointment(a);
    }

    public List<Appointment> getAppointmentsByDate(Date date) throws Exception {
        return dao.getAppointmentsByDate(date);
    }

    public void cancelAppointment(int id) throws Exception {
        dao.cancelAppointment(id);
    }
}
