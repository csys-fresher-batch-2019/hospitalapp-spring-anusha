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
import com.anusha.hospitalApp.dao.DoctorsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Doctors;

@WebServlet("/SearchDoctorByNameServlet")
@SuppressWarnings("serial")
public class SearchDoctorByNameServlet extends HttpServlet {

	@Autowired
	DoctorsDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		try {
			DoctorsDAO dao = DAOFactory.getDoctorsDAO();
			String doctorName = request.getParameter("doctorName");
			List<Doctors> list = dao.findByName(doctorName);
			request.setAttribute("output", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchDoctorResult.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}