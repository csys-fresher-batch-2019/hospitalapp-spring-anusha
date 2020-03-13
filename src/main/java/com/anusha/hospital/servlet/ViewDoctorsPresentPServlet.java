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

import com.anusha.hospital.dao.DoctorsDAO;
import com.anusha.hospital.exception.DBException;
import com.anusha.hospital.model.Doctors;

@WebServlet("/ViewDoctorsPresentPServlet")
@SuppressWarnings("serial")
public class ViewDoctorsPresentPServlet extends HttpServlet {

	@Autowired
	DoctorsDAO d1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Doctors> list = d1.findByPresent();
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewDoctorsPresentP.jsp");
			dispatcher.forward(request, response);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
