package com.anusha.hospitalApp.servlet;

import java.io.IOException;
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

		d1.setId(doctorId);

		DoctorsDAO dao = DAOFactory.getDoctorsDAO();

		try {
			dao.delete(doctorId);
		} catch (DBException e) {
			e.printStackTrace();
		}		
		response.sendRedirect("ViewAllDoctors.jsp");
	}

}
