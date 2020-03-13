<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospital.model.Doctors"%>
<!DOCTYPE html >
<html>
<head>
<title>Doctors list</title>
</head>
<body>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>

	<h2>
		<center>
			<font color=blue>Doctors Details</font>
		</center>
	</h2>
	<center>
		<table border="1">
			</center>
			<thead>
				<tr>
					<th><center>Doctor Id</center></th>
					<th><center>Doctor Name</center></th>
					<th><center>Gender</center></th>
					<th><center>Phone number</center></th>
					<th><center>Department Id</center></th>
					<th><center>Present</center></th>
					<th><center>Number of Appointments</center></th>
					<th><center>Active</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${output}" var="doctors">
					<tr>
						<td>${doctors.id}</td>
						<td>${doctors.name}</td>
						<td>${doctors.gender}</td>
						<td>${doctors.phoneNumber}</td>
						<td>${doctors.departmentId}</td>
						<td>${doctors.present}</td>
						<td>${doctors.noOfAppointment}</td>
						<td>${doctors.active}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>