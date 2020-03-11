<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@page import="com.anusha.hospitalApp.dao.AppointmentsDAO"%>
<%@page import="com.anusha.hospitalApp.model.Appointments"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Appointments</title>
</head>
<body>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<h3>
		<center>
			<font color=blue>Appointments</font>
		</center>
	</h3>
	<center>
		<table border="1">
			</center>
			<thead>
				<tr>
					<th><center>Appointment Id</center></th>
					<th><center>Doctor Id</center></th>
					<th><center>Patient Id</center></th>
					<th><center>Purpose</center></th>
					<th><center>Appointment Status</center></th>
					<th><center>Active</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${output}" var="appointments">
					<tr>
						<td>${appointments.id}</td>
						<td>${appointments.doctorId}</td>
						<td>${appointments.patientId}</td>
						<td>${appointments.purpose}</td>
						<td>${appointments.status}</td>
						<td>${appointments.active}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>