<!DOCTYPE html>
<html>
<head>
<title>Search Doctor Result</title>
</head>
<body>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<form action = "SearchDoctorByNameServlet">
<jsp:include page="Design.jsp"></jsp:include>

<h1><center><font color="blue">Search a doctor</font></center></h1>
<center><font color=blue>Enter Doctor Name : </font> <input type="text" name="doctorName" placeholder="Enter Doctor Name" required autofocus/></center>
<br>
<br>
<center><button class="button"><font color=blue>SEARCH</font></button></center>
</form>
</body>
</html>