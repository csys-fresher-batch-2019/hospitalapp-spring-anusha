package com.anusha.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.anusha.hospital.dao.DoctorsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Doctors;

@SuppressWarnings("serial")
@WebServlet("/DeactivateDoctorProfileServlet")
public class DeactivateDoctorProfileServlet extends HttpServlet {

	@Autowired
	DoctorsDAO dao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String docId = request.getParameter("doctorId");
		int doctorId = Integer.valueOf(docId);

		Doctors d1 = new Doctors();

		d1.setId(doctorId);

		try {
			dao.delete(doctorId);
		} catch (DBException e) {
			e.printStackTrace();
		}
		response.sendRedirect("ViewAllDoctors.jsp");
	}

}
