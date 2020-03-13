package com.anusha.hospital.factory;

import org.springframework.stereotype.Component;
import com.anusha.hospital.dao.AdminDAO;
import com.anusha.hospital.dao.AppointmentsDAO;
import com.anusha.hospital.dao.DepartmentsDAO;
import com.anusha.hospital.dao.DoctorsDAO;
import com.anusha.hospital.dao.PatientsDAO;
import com.anusha.hospital.dao.impl.AdminDAOImpl;
import com.anusha.hospital.dao.impl.AppointmentsDAOImpl;
import com.anusha.hospital.dao.impl.DepartmentsDAOImpl;
import com.anusha.hospital.dao.impl.DoctorsDAOImpl;
import com.anusha.hospital.dao.impl.PatientsDAOImpl;

@Component
public class DAOFactory {

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

		return new AdminDAOImpl();

	}
}