package com.anusha.hospitalApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Doctors;

public interface DoctorsDAO {

	//insert
	int save(Doctors doc) throws ClassNotFoundException, SQLException, DBException;
	
	//display
	List<Doctors> displayDoctors() throws DBException ;
	
	//delete 
	void delete(int departmentId) throws ClassNotFoundException, SQLException, DBException;
	
	//search
	public List<Doctors> findByName(String doctorName) throws SQLException, ClassNotFoundException, DBException;
	
	//doc present
	public List<Doctors> findByPresent() throws DBException;
	
	public List<Doctors> findById(int doctorId) throws ClassNotFoundException, SQLException, DBException;

}
