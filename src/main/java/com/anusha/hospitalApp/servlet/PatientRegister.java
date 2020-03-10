package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.anusha.hospitalApp.dao.PatientsDAO;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Patients;
import com.anusha.hospitalApp.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/PatientRegister")
public class PatientRegister extends HttpServlet {

	private static final Logger LOGGER = Logger.getInstance();

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

		d1.setPatientName(name);
		d1.setAge(pAge);
		d1.setpGender(gender);
		d1.setAddress(address);
		d1.setpPhoneNumber(phoneNumber);
		d1.setPatientPassword(password);
		PatientsDAO dao = DAOFactory.getPatientsDAO();

		List<Patients> list;
		try {
			list = dao.findAll();
		boolean status = false;
			for (Patients patient : list) {
				String phNo = patient.getpPhoneNumber();
				if (phNo.equals(phoneNumber)) {
					status = true;
				}
				System.out.println(status);
			}
			if (status) {
				request.setAttribute("errorMessage1", "Registered already!! Please login...");
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("DoctorRegistration.jsp");
				dispatcher1.forward(request, response);
			} else {
				dao.save(d1);
				response.sendRedirect("PatientLogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
