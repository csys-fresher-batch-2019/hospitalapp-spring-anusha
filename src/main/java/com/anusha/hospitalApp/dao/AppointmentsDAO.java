package com.anusha.hospitalApp.dao;

import java.util.List;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Appointments;

public interface AppointmentsDAO {

	public void save(Appointments app) throws DBException;

	List<Appointments> findAllAppointments() throws DBException;

	public void updateAppointmentStatus(int appointmentId) throws DBException;

	public List<Appointments> findAppointmentByPatientId(int patientId) throws DBException;

	public List<Appointments> findAppointmentByDoctorId(int doctorId) throws DBException;

}
