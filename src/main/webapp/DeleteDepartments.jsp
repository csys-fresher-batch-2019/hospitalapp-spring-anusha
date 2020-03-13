<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Departments</title>
</head>
<body>
	<jsp:include page="Design.jsp"></jsp:include>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<form action="DeleteDepartmentServlet">
		<h2>
			<center>
				<font color="blue">Delete Department</font>
			</center>
		</h2>
		<br> <br>
		<center>
			<font color="blue">Enter Active Status(0/1) : </font> <input
				type="number" name="active" placeholder="Enter active status"
				required autofocus />
		</center>
		<br> <br>
		<center>
			<font color="blue">Enter Department Id : </font> <input type="number"
				name="departmentId" placeholder="Enter Department Id" required
				autofocus />
		</center>
		<br> <br>
		<center>
			<button class="button">DELETE</button>
		</center>
	</form>
</body>
</html>