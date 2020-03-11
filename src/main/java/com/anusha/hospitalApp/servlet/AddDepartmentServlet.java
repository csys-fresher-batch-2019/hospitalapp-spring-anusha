package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.anusha.hospitalApp.exception.ServiceException;
import com.anusha.hospitalApp.model.Departments;
import com.anusha.hospitalApp.service.Service;
import com.anusha.hospitalApp.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {

	private static final Logger LOGGER = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptName = request.getParameter("departmentName");

		LOGGER.debug(deptName);

		Departments d1 = new Departments();
		d1.setName(deptName);
	
			try {
				Service.addDepartment(d1);
				response.sendRedirect("ListDepartmentsServlet");
			} catch (ServiceException e) {
				request.setAttribute("errorMessage2", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddDepartments.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				request.setAttribute("errorMessage2", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("AddDepartments.jsp");
				dispatcher.forward(request, response);
			}
			
		
		
	}
}
