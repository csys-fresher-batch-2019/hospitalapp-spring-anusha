<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@page import="com.anusha.hospitalApp.dao.DoctorsDAO"%>
<%@page import="com.anusha.hospitalApp.model.Doctors"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search Doctor By name</title>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<h1>
	<center>
		<font color="blue">Search Result</font>
	</center>
</h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		<table border="1">
			</center>
			<thread>
			<tr>
				<th><center>Doctor ID</center></th>
				<th><center>Doctor Name</center></th>
				<th><center>Department Id</center></th>
				<th><center>Present</center></th>
			</tr>
			<tbody>
				<c:forEach items="${output}" var="doctors">
					<tr>
						<td>${doctors.id}</td>
						<td>${doctors.name}</td>
						<td>${doctors.departmentId}</td>
						<td>${doctors.present}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>