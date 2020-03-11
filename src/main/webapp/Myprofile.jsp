<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form action=ServletPatientLogin></form>
<h2>
	<center>
		<font color=blue>My Profile</font>
	</center>
</h2>
<body>

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
			
			<tbody><c:if test="${empty sessionScope.id}">
				    </c:if>
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
		</form>
</body>
</html>