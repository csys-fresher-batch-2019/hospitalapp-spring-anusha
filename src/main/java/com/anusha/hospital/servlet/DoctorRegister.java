package com.anusha.hospital.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anusha.hospital.dao.DoctorsDAO;
import com.anusha.hospital.exception.ServiceException;
import com.anusha.hospital.factory.DAOFactory;
import com.anusha.hospital.model.Doctors;
import com.anusha.hospital.service.Service;

@SuppressWarnings("serial")
@WebServlet("/DoctorRegister")
public class DoctorRegister extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("doctorName");
		String phoneNumber = request.getParameter("dPhoneNumber");
		String departmentId = request.getParameter("departmentId");
		int depId = Integer.valueOf(departmentId);
		String gender = request.getParameter("dGender");
		String password = request.getParameter("doctorPassword");

		System.out.println("Name : " + name);
		System.out.println("PhoneNumber : " + phoneNumber);
		System.out.println("DepartmentId : " + depId);
		System.out.println("Gender: " + gender);
		System.out.println("Doctor Password" + password);
		Doctors d1 = new Doctors();

		d1.setName(name);
		d1.setPhoneNumber(phoneNumber);
		d1.setDepartmentId(depId);
		d1.setPassword(password);
		d1.setGender(gender);
		DoctorsDAO dao = DAOFactory.getDoctorsDAO();

		List<Doctors> list;
		try {
			list = dao.findAllDoctors();
			boolean status = false;
			for (Doctors doc : list) {
				String phNo = doc.getPhoneNumber();
				if (phNo.equals(phoneNumber)) {
					status = true;
				}
				System.out.println(status);
			}
			if (status) {
				request.setAttribute("errorMessage", "Registered already!! Please login...");
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("DoctorRegistration.jsp");
				dispatcher1.forward(request, response);
			} else {
				try {
					Service.doctorRegistration(d1);
					response.sendRedirect("DoctorLogin.jsp");
				} catch (ServiceException e) {
					request.setAttribute("errorMessage2", e.getMessage());
					RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorRegistration.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e) {
					request.setAttribute("errorMessage2", e.getMessage());
					RequestDispatcher dispatcher = request.getRequestDispatcher("DoctorRegistration.jsp");
					dispatcher.forward(request, response);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
