<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password?</title>
</head>
<body>
<jsp:include page="Design.jsp"></jsp:include>
<br>
<br>
<br>
<br>
<h2><center><font color = blue>Type Your Registered Phone Number</font></center></h2>
<br>
<br>
<center><font color = blue>Enter PhoneNumber :  <input type="number" name="phNo" 
placeholder="Enter PhoneNumber" required/></font></center>
<br>
<form action= "OtpVerify.jsp">
<center><button class ="button"><font color = blue>Generate OTP</font></button></center>
</form>
</body>
</html>