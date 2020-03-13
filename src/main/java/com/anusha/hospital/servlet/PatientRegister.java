package com.anusha.hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.anusha.hospital.dao.PatientsDAO;
import com.anusha.hospital.exception.ServiceException;
import com.anusha.hospital.model.Patients;
import com.anusha.hospital.service.Service;
import com.anusha.hospital.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/PatientRegister")
public class PatientRegister extends HttpServlet {

	private static final Logger LOGGER = Logger.getInstance();

	@Autowired
	PatientsDAO dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int pAge = Integer.valueOf(age);
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phNo");
		String password = request.getParameter("password");

		LOGGER.debug("Name : " + name);
		LOGGER.debug("Age: " + age);
		LOGGER.debug("Gender: " + gender);
		LOGGER.debug("Address: " + address);
		LOGGER.debug("PhoneNumber : " + phoneNumber);
		LOGGER.debug("Doctor Password" + password);
		Patients d1 = new Patients();

		d1.setName(name);
		d1.setAge(pAge);
		d1.setGender(gender);
		d1.setAddress(address);
		d1.setPhoneNumber(phoneNumber);
		d1.setPassword(password);

		List<Patients> list;
		try {
			list = dao.findAllPatients();
			boolean status = false;
			for (Patients patient : list) {
				String phNo = patient.getPhoneNumber();
				if (phNo.equals(phoneNumber)) {
					status = true;
				}
				System.out.println(status);
			}
			if (status) {
				request.setAttribute("errorMessage1", "Registered already!! Please login...");
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("PatientRegistration.jsp");
				dispatcher1.forward(request, response);
			} else {
				try {
					Service.patientRegistration(d1);
					response.sendRedirect("PatientLogin.jsp");
				} catch (ServiceException e) {
					request.setAttribute("errorMessage1", e.getMessage());
					RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorRegistration.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e) {
					request.setAttribute("errorMessage1", e.getMessage());
					RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorRegistration.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
