
<!DOCTYPE html>
<html>
<head>
<title>Search Patient</title>
</head>
<body>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<form action = "SearchPatientResult.jsp">
<jsp:include page="Design.jsp"></jsp:include>
<center><font color=blue>Enter Patient Id : </font> <input type="number" name="patientId" placeholder="Enter Patient Id" required autofocus/></center>
<br>
<br>
<center><button class="button"><font color=blue>SEARCH</font></button></center>
</form>
</body>
</html>