package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anusha.hospitalApp.dao.DoctorsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Doctors;

@SuppressWarnings("serial")
@WebServlet("/DeactivateDoctorProfileServlet")
public class DeactivateDoctorProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String docId = request.getParameter("doctorId");
		int doctorId = Integer.valueOf(docId);

		Doctors d1 = new Doctors();

		d1.setDoctorId(doctorId);

		DoctorsDAO dao = DAOFactory.getDoctorsDAO();

		try {
			try {
				dao.delete(doctorId);
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("ViewAllDoctors.jsp");
	}

}
