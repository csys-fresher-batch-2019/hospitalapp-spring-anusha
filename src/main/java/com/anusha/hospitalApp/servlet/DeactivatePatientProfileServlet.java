package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.anusha.hospitalApp.dao.PatientsDAO;
import com.anusha.hospitalApp.exception.DBException;
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
			dao.update(patientId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("PatientLogin.jsp");

	}

}
