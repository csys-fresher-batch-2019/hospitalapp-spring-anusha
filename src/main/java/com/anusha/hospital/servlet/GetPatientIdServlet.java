package com.anusha.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.anusha.hospital.dao.PatientsDAO;
import com.anusha.hospital.model.Patients;
import com.anusha.hospital.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/GetPatientIdServlet")
public class GetPatientIdServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getInstance();

	@Autowired
	PatientsDAO dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Patients p = new Patients();

		p.setPhoneNumber((request.getParameter("phonenumber")));
		p.setPassword((request.getParameter("password")));

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