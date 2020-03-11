<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Registration</title>
</head>
<body>
	<jsp:include page="Design.jsp"></jsp:include>
	<form action="DoctorRegister">
		<right> <a href="Home.jsp" class="button">Home</a></right>
		<br> <br> <br>
		<h2>
			<center>
				<font color=blue>DOCTOR REGISTRATION</font>
			</center>
		</h2>
		<br> <br> <br>
		<center>
			<Font color=blue>Enter Name : </Font><input type="name"
				name="doctorName" placeholder="Enter Name" required autofocus />
		</center>
		<br>
		<center>
			<Font color=blue>Enter PhoneNumber : </Font> <input type="text"
				name="dPhoneNumber" placeholder="Enter PhoneNumber" required
				maxlength="10" pattern="\d{10}" title="Enter 10 digits" />
		</center>
		<br>
		<center>
			<Font color=blue>Gender: </Font><input type="radio" name="dGender"
				required onclick=\ "getAnswer('M') value="M"> <Font
				color=blue>Male</Font> <input type="radio" name="dGender" required
				onclick=\ "getAnswer('F') value="F"> <Font color=blue>Female</Font>
		</center>
		<br>
		<center>
			<Font color=blue>Enter Department Id : </Font> <input type="number"
				name="departmentId" placeholder="Enter DepartmentId" />
		</center>
		<br>
		<center>
			<Font color=blue>Enter Password:<input type="password"
				name="doctorPassword" required placeholder="Enter password" />
		</center>
		<br> <br>
		<center>
			<c:if test="${not empty errorMessage2}">
				<font color="red" style="font-style: normal"
					" class="a">${errorMessage2} </font>
			</c:if>
		</center>
		<form action="DoctorFeatures.jsp">
			<center>
				<button class="button">NEXT</button>
			</center>
</body>
</html>