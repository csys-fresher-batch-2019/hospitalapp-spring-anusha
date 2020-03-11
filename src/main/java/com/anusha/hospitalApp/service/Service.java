package com.anusha.hospitalApp.service;

import java.sql.SQLException;

import com.anusha.hospitalApp.dao.DepartmentsDAO;
import com.anusha.hospitalApp.dao.DoctorsDAO;
import com.anusha.hospitalApp.dao.PatientsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.exception.ServiceException;
import com.anusha.hospitalApp.exception.ValidatorException;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Departments;
import com.anusha.hospitalApp.model.Doctors;
import com.anusha.hospitalApp.model.Patients;
import com.anusha.hospitalApp.validator.Validator;

public class Service {
	public static void patientRegistration(Patients pa) throws ServiceException, SQLException {
		PatientsDAO dao = DAOFactory.getPatientsDAO();
			try {
			    Validator.validatePatientRegister(pa);
				dao.save(pa);	
			} catch (ValidatorException e) {
				throw new ServiceException(e.getMessage());
			
			} catch (DBException e) {
				throw new ServiceException(e.getMessage());
			} 
	}
	public static void doctorRegistration(Doctors doc) throws ServiceException, SQLException {
		DoctorsDAO dao = DAOFactory.getDoctorsDAO();
		try {
		    Validator.validateDoctorRegister(doc);
			dao.save(doc);	
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		} 		
	}
	public static void addDepartment(Departments dept) throws ServiceException, SQLException {
		DepartmentsDAO dao = DAOFactory.getDepartmentsDAO();
		try {
		    Validator.validateDepartment(dept);
			dao.save(dept);	
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		
		} catch (DBException e) {
			throw new ServiceException(e.getMessage());
		} 		
	}
}
