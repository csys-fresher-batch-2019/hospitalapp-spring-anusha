<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Register</title>
<body>
<form action = "RegisterServlet">
<jsp:include page="Design.jsp"></jsp:include>
</form>
<br>
<br>
<br>
<br>
<h2><center><font color=blue>User Registration</font></center></h2>
<h3 align="center"><font color=blue>Select the appropriate option</font></h3>
<form action = "DoctorRegistration.jsp">
<br>
<br>
<center><button class="button">Doctor Registration</button></center>
</form>
<form action = "PatientRegistration.jsp">
<br>
<br>
<br>
<center><button class ="button">Patient Registration</button></center>
</form>
</body>
</html>