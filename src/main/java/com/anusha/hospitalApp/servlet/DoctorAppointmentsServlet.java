package com.anusha.hospitalApp.servlet;

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
import com.anusha.hospitalApp.dao.AppointmentsDAO;
import com.anusha.hospitalApp.model.Appointments;

@WebServlet("/DoctorAppointmentsServlet")
@SuppressWarnings("serial")
public class DoctorAppointmentsServlet extends HttpServlet {

	@Autowired
	AppointmentsDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String doctorId = request.getParameter("doctorId");
			int docId = Integer.valueOf(doctorId);
			List<Appointments> list = dao.findByDoctorId(docId);
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorAppointmentsResult.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
