<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.anusha.hospital.factory.DAOFactory"%>
<%@page import="com.anusha.hospital.dao.PatientsDAO"%>
<%@page import="com.anusha.hospital.model.Patients"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
</head>
<body>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<h3>
		<center>
			<font color=blue>Patient Details</font>
		</center>
	</h3>
	<center>
		<table border="1">
			</center>
			<thread>
			<tr>
				<th>Patient Id</th>
				<th>Patient Name</th>
				<th>Phone Number</th>
				<th>Gender</th>
				<th>Age</th>
				<th>Address</th>
				<th>Active</th>
			</tr>
			<tbody>
				<c:forEach items="${output}" var="patients">
					<tr>
						<td>${patients.id}</td>
						<td>${patients.name}</td>
						<td>${patients.phoneNumber}</td>
						<td>${patients.gender}</td>
						<td>${patients.age}</td>
						<td>${patients.address}</td>
						<td>${patients.active}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>