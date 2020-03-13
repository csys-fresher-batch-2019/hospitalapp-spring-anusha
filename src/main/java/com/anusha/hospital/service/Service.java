package com.anusha.hospital.service;

import java.sql.SQLException;
import com.anusha.hospital.dao.DepartmentsDAO;
import com.anusha.hospital.dao.DoctorsDAO;
import com.anusha.hospital.dao.PatientsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.exception.ServiceException;
import com.anusha.hospital.exception.ValidatorException;
import com.anusha.hospital.factory.DAOFactory;
import com.anusha.hospital.model.Departments;
import com.anusha.hospital.model.Doctors;
import com.anusha.hospital.model.Patients;
import com.anusha.hospital.validator.Validator;

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
