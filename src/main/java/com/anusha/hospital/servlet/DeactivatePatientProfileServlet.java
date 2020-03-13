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
import com.anusha.hospital.exception.DBException;

@SuppressWarnings("serial")
@WebServlet("/DeactivatePatientProfileServlet")
public class DeactivatePatientProfileServlet extends HttpServlet {

	@Autowired
	PatientsDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession sess = request.getSession(false);
			int patientId = (Integer) (sess.getAttribute("patientId"));
			dao.updateById(patientId);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("PatientLogin.jsp");

	}

}
