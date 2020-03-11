package com.anusha.hospitalApp.dao;

import java.util.List;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Doctors;
import com.anusha.hospitalApp.model.Patients;

public interface PatientsDAO {

	void save(Patients p) throws DBException;

	public boolean login(Patients user) throws DBException;

	List<Patients> findAllPatients() throws DBException;

	void updateById(int patientId) throws DBException;

	public List<Doctors> joinDepartmentsDoctors() throws DBException;

	public List<Patients> findById(int patientId) throws DBException;

	public int findId(String pPhoneNumber, String patientPassword) throws DBException;
}
