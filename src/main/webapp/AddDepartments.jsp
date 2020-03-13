<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h2>
	<center>
		<font color="blue">Add New Department</font>
	</center>
</h2>
</head>
<title>Add Departments</title>
<body>
	<jsp:include page="Design.jsp"></jsp:include>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<form action="AddDepartmentServlet">
		<center>
			<font color="blue">Enter Department Name : </font><input type="name"
				name="departmentName" placeholder="Enter Department Name" required
				autofocus />
		</center>
		<br>
		<center>
			<c:if test="${not empty errorMessage2}">
				<font color="red" style="font-style: normal" " class="a">${errorMessage2}
			</c:if>
		</center>
		<br> <br>
		<center>
			<button class="button">ADD</button>
		</center>
	</form>
</body>
</html>
