package com.anusha.hospital.dao;

import java.util.List;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Appointments;

public interface AppointmentsDAO {

	public void save(Appointments app) throws DBException;

	List<Appointments> findAllAppointments() throws DBException;

	public int updateAppointmentStatus(int appointmentId) throws DBException;

	public List<Appointments> findAppointmentByPatientId(int patientId) throws DBException;

	public List<Appointments> findAppointmentByDoctorId(int doctorId) throws DBException;

}
