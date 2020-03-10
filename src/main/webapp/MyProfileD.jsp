<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Doctors"%>
<%@page import="com.anusha.hospitalApp.dao.DoctorsDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
</head>
<body>
<jsp:include page="DoctorNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<form action = DoctorLoginServlet></form>
<h3><center><font color=blue>My Details</font></center></h3>
<% 
ArrayList<Doctors> a = (ArrayList)request.getAttribute("output");
%>
<body>

<center><table border="1"></center>
<thread><tr><th>Doctor Id</th>
<th>Doctor Name</th>
<th>Department Id</th>
<th>Phone Number</th>
<th>Gender</th>
<th>Number of appointments</th>
<th>Present</th>
<th>Active</th></tr>
<tbody>
<%
for (Doctors doc : a) {%>
<tr>
<td><%= doc.getDoctorId() %></td>
<td><%= doc.getDoctorName() %></td>
<td><%= doc.getDepartmentId() %>
<td><%= doc.getdPhoneNumber() %></td>
<td><%= doc.getdGender() %></td>
<td><%= doc.getNoOfAppointment() %></td>
<td><%= doc.getDoctorPresent() %></td>
<td><%= doc.getActive() %></td>
</tr>
<%}
%>
</tbody>
</table>
</form>
</body>
</html>