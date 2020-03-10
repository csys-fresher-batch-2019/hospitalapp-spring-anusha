package com.anusha.hospitalApp.factory;

import org.springframework.stereotype.Component;
import com.anusha.hospitalApp.dao.AdminDAO;
import com.anusha.hospitalApp.dao.AppointmentsDAO;
import com.anusha.hospitalApp.dao.DepartmentsDAO;
import com.anusha.hospitalApp.dao.DoctorsDAO;
import com.anusha.hospitalApp.dao.PatientsDAO;
import com.anusha.hospitalApp.dao.impl.AdminDAOImpl;
import com.anusha.hospitalApp.dao.impl.AppointmentsDAOImpl;
import com.anusha.hospitalApp.dao.impl.DepartmentsDAOImpl;
import com.anusha.hospitalApp.dao.impl.DoctorsDAOImpl;
import com.anusha.hospitalApp.dao.impl.PatientsDAOImpl;

@Component
public class DAOFactory {

//	private DAOFactory() {
//		throw new IllegalStateException("Utility class");
//	}

	public static DepartmentsDAO getDepartmentsDAO() {

		return new DepartmentsDAOImpl();

	}

	public static DoctorsDAO getDoctorsDAO() {

		return new DoctorsDAOImpl();

	}

	public static PatientsDAO getPatientsDAO() {

		return new PatientsDAOImpl();

	}

	public static AppointmentsDAO getAppointmentsDAO() {

		return new AppointmentsDAOImpl();

	}

	public static AdminDAO getAdminDAO() {
		
		return  new AdminDAOImpl();
		
	}
}