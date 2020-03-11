package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.anusha.hospitalApp.dao.PatientsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Patients;

@WebServlet("/SearchPatientByIdServlet")
@SuppressWarnings("serial")
public class SearchPatientByIdServlet extends HttpServlet {

	@Autowired
	PatientsDAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String patientId = request.getParameter("patientId");
			int pId = Integer.valueOf(patientId);
			List<Patients> list = dao.findById(pId);
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchPatientResult.jsp");
			dispatcher.forward(request, response);
		
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
