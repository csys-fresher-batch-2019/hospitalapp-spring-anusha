<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Appointments"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Doctor's Appointments</title>
</head>
<body>
	<jsp:include page="DoctorNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<center>
		<h3>
			<font color=blue>My Appointments</font>
		</h3>
	</center>
	<%
		ArrayList<Appointments> a = (ArrayList) request.getAttribute("output");
	%>
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
				<%
					for (Appointments app : a) {
				%>
				<tr>
					<td><%=app.getAppointmentId()%></td>
					<td><%=app.getDoctorId()%></td>
					<td><%=app.getPatientId()%></td>
					<td><%=app.getPurpose()%></td>
					<td><%=app.getAppointmentStatus()%>
					<td><%=app.getActive()%>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
</body>
</body>
</html>