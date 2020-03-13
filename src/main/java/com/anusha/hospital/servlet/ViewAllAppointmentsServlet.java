package com.anusha.hospital.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.anusha.hospital.dao.AppointmentsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Appointments;

@WebServlet("/ViewAllAppointmentsServlet")
@SuppressWarnings("serial")
public class ViewAllAppointmentsServlet extends HttpServlet {

	@Autowired
	AppointmentsDAO d1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Appointments> list = d1.findAllAppointments();
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAllAppointments.jsp");
			dispatcher.forward(request, response);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
