package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anusha.hospitalApp.dao.DepartmentsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Departments;
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
		d1.setDepartmentName(deptName);
		DepartmentsDAO dao = DAOFactory.getDepartmentsDAO();
		try {
			try {
				dao.save(d1);
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
		response.sendRedirect("ListDepartmentsServlet");
		
	}
}
