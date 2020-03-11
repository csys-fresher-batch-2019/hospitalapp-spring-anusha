package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.anusha.hospitalApp.dao.AppointmentsDAO;
import com.anusha.hospitalApp.exception.DBException;
import com.anusha.hospitalApp.factory.DAOFactory;
import com.anusha.hospitalApp.model.Appointments;
import com.anusha.hospitalApp.util.Logger;

@SuppressWarnings("serial")
@WebServlet("/AddAnAppointmentServlet")
public class AddAnAppointmentServlet extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String patId = request.getParameter("patientId");
		int pId = Integer.valueOf(patId);
		String purpose =request.getParameter("purpose");
		String doctorId = request.getParameter("doctorId");
		int docId = Integer.valueOf(doctorId);

		LOGGER.debug(pId);
		
		Appointments d1 = new Appointments();
		d1.setPatientId(pId);
		d1.setPurpose(purpose);
		d1.setDoctorId(docId);
		
		AppointmentsDAO dao = DAOFactory.getAppointmentsDAO();
		
		try {
			dao.save(d1);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("DisplayPatientAppointmentsServlet");
	}

}
