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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.anusha.hospitalApp.dao.AppointmentsDAO;
import com.anusha.hospitalApp.model.Appointments;

@WebServlet("/MyAppointmentsDServlet")
@SuppressWarnings("serial")
public class MyAppointmentsDServlet extends HttpServlet {

	@Autowired
	AppointmentsDAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			HttpSession sess=request.getSession(false);
			int doctorId=(Integer)(sess.getAttribute("doctorId"));
			List<Appointments> list =dao.findByDoctorId(doctorId);
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayDoctorAppointments.jsp");
			dispatcher.forward(request, response);
			
		} 
		
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
