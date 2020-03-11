<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Doctors"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctors Present</title>
</head>
<body>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<h1>
		<center>
			<font color="blue">View all doctors present</font>
		</center>
	</h1>
	<center>
		<table border="1">
			</center>
			<thead>
				<tr>
					<th><center>Doctor Id</center></th>
					<th><center>Doctor Name</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${output}" var="doctors">
					<tr>
						<td>${doctors.id}</td>
						<td>${doctors.name}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>