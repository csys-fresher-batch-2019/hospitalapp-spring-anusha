package com.anusha.hospitalApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Departments;

public interface DepartmentsDAO {
	
	//insert
	void save(Departments dept) throws ClassNotFoundException, SQLException, DBException;
	
	//select
	List<Departments> findByActive() throws ClassNotFoundException, SQLException, DBException;
	
	//update
	void update(int active, int departmentID ) throws ClassNotFoundException, SQLException, DBException;

	//admin view
	public List<Departments> findAll() throws ClassNotFoundException, SQLException, DBException ;

}
