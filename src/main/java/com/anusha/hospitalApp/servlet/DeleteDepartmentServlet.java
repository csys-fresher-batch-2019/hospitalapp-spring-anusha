package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.anusha.hospitalApp.dao.DepartmentsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Departments;

@SuppressWarnings("serial")
@WebServlet("/DeleteDepartmentServlet")
public class DeleteDepartmentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String active = request.getParameter("active");
		int act = Integer.valueOf(active);
		String deptId = request.getParameter("departmentId");
		int depId = Integer.valueOf(deptId);
		
		Departments d1 = new Departments();
		
		d1.setActive(act);
		d1.setId(depId);
		
		DepartmentsDAO dao = DAOFactory.getDepartmentsDAO();
		
		try {
				dao.updateDepartmentStatus(act, depId);
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		response.sendRedirect("ViewDepartmentDetailsServlet");
	}
}
