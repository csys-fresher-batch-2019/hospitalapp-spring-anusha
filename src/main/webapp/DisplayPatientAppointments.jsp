<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Appointments"%>
<html>
<head>
<title>Patient's Appointments</title>
</head>
<body>
	<jsp:include page="PatientNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<h3>
		<center>
			<font color=blue>Patient's Appointments</font>
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
</body>
</html>