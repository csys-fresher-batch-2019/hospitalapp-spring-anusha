package com.anusha.hospitalApp.dao;

import java.util.List;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Departments;

public interface DepartmentsDAO {

	void save(Departments dept) throws DBException;

	List<Departments> findActiveDepartments() throws DBException;

	void updateDepartmentStatus(int active, int departmentID) throws DBException;

	public List<Departments> findAllDepartments() throws DBException;

}
