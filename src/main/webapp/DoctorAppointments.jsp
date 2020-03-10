<!DOCTYPE html>
<html>
<head>
<title>Doctor's Appointments</title>
</head>
<body>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<form action="DoctorAppointmentsServlet">
		<jsp:include page="Design.jsp"></jsp:include>
		<h3>
			<center>
				<font color=blue>Doctor's Appointments</font>
			</center>
		</h3>

		<center>
			<font color=blue>Enter Doctor Id : </font> <input type="number"
				name="doctorId" placeholder="Enter Doctor Id" required autofocus />
		</center>
		<br> <br>
		<center>
			<button class="button">
				<font color=blue>SEARCH</font>
			</button>
		</center>
	</form>
</body>
</html>