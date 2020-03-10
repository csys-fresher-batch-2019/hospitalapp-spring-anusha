<!DOCTYPE html>
<html>
<head>
<title>Patient's Appointments</title>
</head>
<body>
<jsp:include page="PatientNavBar.jsp"></jsp:include>
<form action = "PatientAppointmentsServlet">
<jsp:include page="Design.jsp"></jsp:include>
<h3><center><font color=blue>Patient's Appointments</font></center></h3>

<center><font color=blue>Enter Patient Id : </font> <input type="number" name="patientId" placeholder="Enter Patient Id" required autofocus/></center>
<br>
<br>
<center><button class="button"><font color=blue>SEARCH</font></button></center>

</body>
</body>
</html>