<%@page import="com.anusha.hospitalApp.model.Patients"%>
<%@page import="java.util.List"%>
<%@page import="com.anusha.hospitalApp.factory.DAOFactory"%>
<%@page import="com.anusha.hospitalApp.dao.PatientsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deactivate Account</title>
</head>
<body>
<form action="PatientLogin.jsp">
<jsp:include page="PatientNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<%
	PatientsDAO dao =DAOFactory.getPatientsDAO();
HttpSession sess=request.getSession(false);
int patientId=(Integer)(sess.getAttribute("patientId"));
dao.update(patientId);
%>
<h3><center><font color= blue>Are you sure you want to deactivate this account?</font></center></h3>
<center><button class="button">Remove</button></center>
</form>
<br>
<br>
<center><form action="PatientFeatures.jsp"><button class="button">Cancel</button></center>
</body>
</html>