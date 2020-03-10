<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@page import="com.anusha.hospitalApp.dao.PatientsDAO"%>
<%@page import="com.anusha.hospitalApp.model.Patients"%>
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

<h3><center><font color=blue>Patient Details</font></center></h3>

<%
	PatientsDAO dao = DAOFactory.getPatientsDAO();
String patientId = request.getParameter("patientId");
int pId=Integer.valueOf(patientId);
List<Patients> list = dao.findById(pId);
%>
<center><table border="1"></center>
<thread><tr><th>Patient Id</th><th>PAtient Name</th><th>Phone Number</th><th>Gender</th><th>Age</th><th>Address</th><th>Active</th></tr>
<tbody>
<%
for (Patients p : list) {%>
<tr>
<td><%= p.getPatientId() %></td>
<td><%= p.getPatientName() %></td>
<td><%= p.getpPhoneNumber() %></td>
<td><%= p.getpGender() %></td>
<td><%= p.getAge() %></td>
<td><%= p.getAddress() %></td>
<td><%= p.getActivePatient() %></td>
</tr>
<%}
%>

</tbody>
</table>
</body>
</html>