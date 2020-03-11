<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
</head>
<body>
	<jsp:include page="DoctorNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<form action=DoctorLoginServlet></form>
	<h3>
		<center>
			<font color=blue>My Details</font>
		</center>
	</h3>
<body>

	<center>
		<table border="1">
			</center>
			<thread>
			<tr>
				<th>Doctor Id</th>
				<th>Doctor Name</th>
				<th>Gender</th>
				<th>Phone Number</th>			
				<th>Department Id</th>
				<th>Present</th>
				<th>Number of appointments</th>				
				<th>Active</th>
			</tr>
			<tbody>
				<c:if test="${empty sessionScope.id}">
				</c:if>
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
		</form>
</body>
</html>