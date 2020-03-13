package com.anusha.hospital.dao;

import java.util.List;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Departments;

public interface DepartmentsDAO {

	void save(Departments dept) throws DBException;

	List<Departments> findActiveDepartments() throws DBException;

	public int updateDepartmentStatus(int active, int departmentID) throws DBException;

	public List<Departments> findAllDepartments() throws DBException;

}
