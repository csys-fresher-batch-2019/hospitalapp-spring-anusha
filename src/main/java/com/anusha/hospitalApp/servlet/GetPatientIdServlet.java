package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anusha.hospitalApp.dao.impl.PatientsDAOImpl;
import com.anusha.hospitalApp.model.Patients;
import com.anusha.hospitalApp.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/GetPatientIdServlet")
public class GetPatientIdServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Patients p = new Patients();

		p.setPhoneNumber((request.getParameter("phonenumber")));
		p.setPassword((request.getParameter("password")));
		PatientsDAOImpl dao = new PatientsDAOImpl();

		try {
			Integer uid = dao.findId(p.getPhoneNumber(), p.getPassword());
			if (uid != null) {

				HttpSession sess = request.getSession();
				sess.setAttribute("patientId", uid);

				LOGGER.debug(uid);
				
			}

		} catch (Exception e) {

			LOGGER.error(e);
		}

	}

}