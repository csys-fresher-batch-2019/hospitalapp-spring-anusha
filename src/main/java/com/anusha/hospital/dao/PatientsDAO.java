package com.anusha.hospital.dao;

import java.util.List;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Doctors;
import com.anusha.hospital.model.Patients;

public interface PatientsDAO {

	void save(Patients p) throws DBException;

	public boolean login(Patients user) throws DBException;

	List<Patients> findAllPatients() throws DBException;

	int updateById(int patientId) throws DBException;

	public List<Doctors> joinDepartmentsDoctors() throws DBException;

	public List<Patients> findById(int patientId) throws DBException;

	public int findId(String pPhoneNumber, String patientPassword) throws DBException;
}
