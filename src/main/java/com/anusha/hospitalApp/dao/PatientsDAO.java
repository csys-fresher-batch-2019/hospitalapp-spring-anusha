package com.anusha.hospitalApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Doctors;
import com.anusha.hospitalApp.model.Patients;

public interface PatientsDAO {
	
	//insert
	void save(Patients p) throws ClassNotFoundException, SQLException, DBException;
	
	//display
	List<Patients> findAll() throws DBException ;
	
	//delete 
	void update(int patientId) throws ClassNotFoundException, SQLException, DBException;

	//doc list
	public List<Doctors> joinDepartmentsDoctors() throws SQLException, ClassNotFoundException, DBException;

	//profile
	public List<Patients> findById(int patientId) throws SQLException, ClassNotFoundException, DBException;

	//get id
	public int findByPhNoPasswrd(String pPhoneNumber, String patientPassword) throws DBException ;
}
