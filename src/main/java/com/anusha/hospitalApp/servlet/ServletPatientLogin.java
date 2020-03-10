package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anusha.hospitalApp.dao.impl.PatientsDAOImpl;
import com.anusha.hospitalApp.model.Patients;
import com.anusha.hospitalApp.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/ServletPatientLogin")
public class ServletPatientLogin extends HttpServlet {

	private static final Logger LOGGER=Logger.getInstance(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean status = false;
		
		String pPhoneNumber = request.getParameter("pPhoneNumber");
		String patientPassword = request.getParameter("patientPassword");
        
        Patients user = new Patients();
        user.setpPhoneNumber(pPhoneNumber);
        user.setPatientPassword(patientPassword);
        PatientsDAOImpl dao = new PatientsDAOImpl();
       
        try {
			status = user.login(user);
			System.out.println(status);
			Integer uid=dao.findByPhNoPasswrd(user.getpPhoneNumber(),user.getPatientPassword());
			if ( uid != null) {

			      HttpSession sess=request.getSession();
			      sess.setAttribute("patientId", uid);
			      
			LOGGER.debug(uid);
			     // response.sendRedirect("ListDepartments.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status==true)
			response.sendRedirect("PatientFeatures.jsp");
		else {
			// out.print("<script> alert(Login failed);</script>");
			request.setAttribute("errorMessage", "Invalid Credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("PatientLogin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
