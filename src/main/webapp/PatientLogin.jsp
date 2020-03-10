<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html5>
<html>
<head>
<title>Patient Login</title>
</head>
<body>
<jsp:include page="Design.jsp"></jsp:include>
<right> <a href="Home.jsp" class="button">Home</a></right>
<form action = "ServletPatientLogin">
<h1><center><font color="blue">Patient Login </font></center></h1>
<center><font color="blue">Enter PhoneNumber :  </font><input type="text" name="pPhoneNumber" 
placeholder="Enter PhoneNumber" required maxlength ="10" pattern ="\d{10}" title= "Enter 10 digits"/></center>
<br/>
<br/>
<center><font color="blue">Enter Password: </font><input type="password" name="patientPassword" required /></center>
<ul>
<center> <a href="ForgotPassword.jsp" ><font color="blue">ForgotPassword?</font></a></center> 
</ul>
<%String errorMessage = (String)request.getAttribute("Error Message");
if(errorMessage != null){%>
<center><font color = "red"><%=errorMessage %></center>
<%} %>
<center><button class ="button">Login</button></center>
</form>
</font>
</form>
</body>
</html>