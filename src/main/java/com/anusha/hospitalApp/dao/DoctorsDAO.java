package com.anusha.hospitalApp.dao;

import java.util.List;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Doctors;

public interface DoctorsDAO {

	int save(Doctors doc) throws DBException;

	public boolean login(Doctors doc) throws DBException;

	public int findId(String dPhoneNumber, String doctorPassword) throws DBException;

	List<Doctors> findAllDoctors() throws DBException;

	void delete(int departmentId) throws DBException;

	public List<Doctors> findByName(String doctorName) throws DBException;

	public List<Doctors> findByPresent() throws DBException;

	public List<Doctors> findById(int doctorId) throws DBException;

}
