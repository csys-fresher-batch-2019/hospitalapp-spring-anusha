<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@page import="com.anusha.hospitalApp.dao.PatientsDAO"%>
<%@page import="com.anusha.hospitalApp.model.Patients"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="PatientNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<title>My Profile</title>
</head>
<form action = ServletPatientLogin></form>
<h2><center><font color=blue>My Profile</font></center></h2>
<% 
ArrayList<Patients> a = (ArrayList)request.getAttribute("output");
%>
<body>

<center><table border="1"></center>
<thread><tr><th>Patient Id</th><th>Patient Name</th><th>Phone Number</th><th>Gender</th><th>Age</th><th>Address</th><th>Active</th></tr>
<tbody>
<%
for (Patients p : a) {%>
<tr>
<td><%= p.getPatientId() %></td>
<td><%= p.getPatientName() %></td>
<td><%= p.getpPhoneNumber() %></td>
<td><%= p.getpGender() %></td>
<td><%= p.getAge() %></td>
<td><%= p.getAddress() %></td>
<td><%= p.getActivePatient() %></td>
</tr>
<%}
%>
</tbody>
</table>
</form>
</body>
</html>