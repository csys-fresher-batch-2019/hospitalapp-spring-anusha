<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h2>
	<center>
		<font color=blue><font>Fix An Appointment</font>
	</center>
</h2>
</head>
<body>
	<title>Fix An Appointment</title>
	<jsp:include page="PatientNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<form action="AddAnAppointmentServlet">		
		<center>
			<font color=blue>Enter Patient Id : </font><input type="number"
				name="patientId" placeholder="Enter Patient Id:" required autofocus />
		</center>
		<br> <br> <br>
		<center>
			<font color=blue>Enter Purpose : </font><input type="text"
				name="purpose" placeholder="Enter Purpose:" required autofocus />
		</center>
		<br> <br> <br>
		<center>
			<font color=blue>Enter Doctor Id : </font><input type="number"
				name="doctorId" placeholder="Enter Doctor Id:" required autofocus />
		</center>
		<br> <br> <br>
		<center>
			<button class="button">FIX</button>
		</center>
	</form>
</body>
</html>