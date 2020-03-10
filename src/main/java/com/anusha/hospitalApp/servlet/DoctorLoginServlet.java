package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anusha.hospitalApp.dao.impl.DoctorsDAOImpl;
import com.anusha.hospitalApp.model.Doctors;
import com.anusha.hospitalApp.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {

	private static final Logger LOGGER=Logger.getInstance(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = false;
		
		String dPhoneNumber = request.getParameter("dPhoneNumber");
		String DoctorPassword = request.getParameter("doctorPassword");
        
        Doctors user = new Doctors();
        user.setdPhoneNumber(dPhoneNumber);
        user.setDoctorPassword(DoctorPassword);
        DoctorsDAOImpl dao = new DoctorsDAOImpl();
		
		try {
			status = user.login(user);
			System.out.println(status);
			Integer uid=dao.getUserId(user.getdPhoneNumber(),user.getDoctorPassword());
			if ( uid != null) {

			      HttpSession sess=request.getSession();
			      sess.setAttribute("doctorId", uid);
			      
			LOGGER.debug(uid);
			     // response.sendRedirect("ListDepartments.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status==true)
			response.sendRedirect("DoctorFeatures.jsp");
		else {
			request.setAttribute("Error Message", "Invalid Credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorLogin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
