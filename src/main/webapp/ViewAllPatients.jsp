<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Patients"%>
<!DOCTYPE html>
<html>
<title>List Patients</title>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>

<h3>
	<center>
		<font color=blue>List Patients</font>
	</center>
</h3>
<%
	ArrayList<Patients> a = (ArrayList) request.getAttribute("output");
%>
<body>
	<center>
		<table border="1">
			</center>
			<thead>
				<tr>
					<th><center>Patient Id</center></th>
					<th><center>Patient Name</center></th>
					<th><center>Age</center></th>
					<th><center>Gender</center></th>
					<th><center>Address</center></th>
					<th><center>Phone number</center></th>
					<th><center>Active</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${output}" var="patients">
					<tr>
						<td>${patients.patientId}</td>
						<td>${patients.patientName}</td>
						<td>${patients.age}</td>
						<td>${patients.pGender}</td>
						<td>${patients.address}</td>
						<td>${patients.pPhoneNumber}</td>
						<td>${patients.activePatient}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>