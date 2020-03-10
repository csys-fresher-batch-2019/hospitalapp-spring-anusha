<!DOCTYPE html>
<html>
<head>
<title>Search Doctor Result</title>
</head>
<body>
<jsp:include page="PatientNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<form action = "SearchDoctorByNamePServlet">
<h2><center><font color=blue>Search Doctor</font></center></h2>
<center><font color=blue>Enter Doctor Name : </font><input type="text" name="doctorName" placeholder="Enter Doctor Name" required autofocus/></center>
<br>
<br>
<center><button class="button">SEARCH</button></center>
</form>
</body>
</html>