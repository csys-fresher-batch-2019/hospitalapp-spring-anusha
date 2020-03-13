<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deactivate Doctor Profile</title>
</head>
<body>
	<form action="DeactivateDoctorProfileServlet">
		<jsp:include page="AdminNavBar.jsp"></jsp:include>
		<jsp:include page="Design.jsp"></jsp:include>
		<h1>
			<center>
				<font color="blue">Deactivate doctor account</font>
			</center>
		</h1>
		<center>
			<font color="blue">Enter Doctor Id : </font> <input type="number"
				name="doctorId" placeholder="Enter Doctor Id" required autofocus />
		</center>
		<br> <br>
		<center>
			<button class="button">Deactivate</button>
		</center>
	</form>
</body>
</html>