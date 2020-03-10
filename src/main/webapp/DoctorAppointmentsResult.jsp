<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@page import="com.anusha.hospitalApp.dao.AppointmentsDAO"%>
<%@page import="com.anusha.hospitalApp.model.Appointments"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor's Appointment List</title>
</head>
<body>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<h3><center><font color=blue>Doctor's Appointments</font></center></h3>

<% ArrayList<Appointments> a = (ArrayList)request.getAttribute("output");%>
<center><table border="1"></center>
<thead><tr><th><center>Appointment Id </center></th> <th><center>Doctor Id</center> </th> <th><center>Patient Id</center> </th> <th><center>Purpose</center> </th> <th><center>Appointment Status</center> </th> <th><center>Active</center> </th> </tr></thead>
<tbody>
<%
for (Appointments app : a) {%>
<tr>
<td><%= app.getAppointmentId() %></td>
<td><%= app.getDoctorId() %></td>
<td><%= app.getPatientId() %></td>
<td><%= app.getPurpose() %></td>
<td><%=app.getAppointmentStatus()  %>
<td><%= app.getActive() %>
</tr>
<%}
%>

</tbody>
</table>
</body>
</html>