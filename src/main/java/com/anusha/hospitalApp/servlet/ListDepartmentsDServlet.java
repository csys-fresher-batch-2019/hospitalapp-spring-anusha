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
import com.anusha.hospitalApp.dao.DepartmentsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.model.Departments;

@SuppressWarnings("serial")
@WebServlet("/ListDepartmentsDServlet")
public class ListDepartmentsDServlet extends HttpServlet {
	
	@Autowired
	DepartmentsDAO d1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			List<Departments>list =d1.findActiveDepartments();
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListDepartmentsD.jsp");
			dispatcher.forward(request, response);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
