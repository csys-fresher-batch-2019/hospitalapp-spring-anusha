package com.anusha.hospitalApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Appointments;

public interface AppointmentsDAO {

	//insert
	public void save(Appointments app) throws SQLException, ClassNotFoundException, DBException;
	
	//display
	List<Appointments> findAll() throws ClassNotFoundException, SQLException;
	
	//delete
	public void update(int appointmentId) throws ClassNotFoundException, SQLException;
	
	//display by patient_id
	
	public List<Appointments> findByPatientId(int patientId) throws SQLException, ClassNotFoundException;
	
	public List<Appointments> findByDoctorId(int doctorId) throws SQLException, ClassNotFoundException;
	
}
