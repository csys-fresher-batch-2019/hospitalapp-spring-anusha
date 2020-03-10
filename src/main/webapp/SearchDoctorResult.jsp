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
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
	<h1>
		<center><font color="blue">Search Result</font></center>
	</h1>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Doctor By name</title>
</head>
<% ArrayList<Doctors> a = (ArrayList)request.getAttribute("output");
%>
<body>
<center><table border="1"></center>
<thread><tr><th><center>Doctor ID</center></th><th><center>Doctor Name</center></th><th><center>Department Id</center></th><th><center>Present</center></th></tr>
<tbody>
<%
for (Doctors doc : a) {%>
<tr>
<td><%= doc.getDoctorId() %></td>
<td><%= doc.getDoctorName() %></td>
<td><%= doc.getDepartmentId() %></td>
<td><%= doc.getDoctorPresent() %></td>
</tr>
<%}
%>

</tbody>
</table>
</body>
</html>