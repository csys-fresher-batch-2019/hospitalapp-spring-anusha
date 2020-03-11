package com.anusha.hospitalApp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.anusha.hospitalApp.model.Admin;

@SuppressWarnings("serial")
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Admin user = new Admin();
		System.out.println("Enter UserName : " + username);
		user.setName(username);
		System.out.println("Enter Password : " + password);
		user.setPassword(password);

		if (username.equals("Admin") && password.equals("123")) {
			response.sendRedirect("AdminFeatures.jsp");
		} else {
			request.setAttribute("errorMessage", "Try Again");
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);
		}
	}
}
