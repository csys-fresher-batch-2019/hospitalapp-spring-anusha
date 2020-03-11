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
        user.setPhoneNumber(dPhoneNumber);
        user.setPassword(DoctorPassword);
        DoctorsDAOImpl dao = new DoctorsDAOImpl();
		
		try {
			status = dao.login(user);
			System.out.println(status);
			Integer uid=dao.findId(user.getPhoneNumber(),user.getPassword());
			if ( uid != null) {

			      HttpSession sess=request.getSession();
			      sess.setAttribute("doctorId", uid);
			      
			LOGGER.debug(uid);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status==true)
			response.sendRedirect("DoctorFeatures.jsp");
		else {
			request.setAttribute("errorMessage2", "Invalid Credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorLogin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
