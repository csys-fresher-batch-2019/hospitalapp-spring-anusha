<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html5>
<html>
<head>
<title>Doctor Login</title>
</head>
<body>
	<form action="DoctorLoginServlet">
		<jsp:include page="Design.jsp"></jsp:include>
		<right> <a href="Home.jsp" class="button">Home</a></right>
		<h3>
			<center>
				<font color=blue>Doctor's Login</font>
			</center>
		</h3>
		<center>
			<font color=blue>Enter PhoneNumber : </font><input type="text"
				name="dPhoneNumber" placeholder="Enter PhoneNumber" required
				maxlength="10" pattern="\d{10}" title="Enter 10 digits" />
		</center>
		<br /> <br />
		<center>
			<font color=blue>Enter Password: </font><input type="password"
				name="doctorPassword" required />
		</center>
		<ul>
			<center>
				<a href="ForgotPassword.jsp">ForgotPassword?</a>
			</center>
		</ul>
		<center>
			<c:if test="${not empty errorMessage2}">
				<font color="red" style="font-style: normal" " class="a">${errorMessage2}
				</font>
			</c:if>
		</center>
		<center>
			<button class="button">Login</button>
		</center>
	</form>
	</font>
	</form>
</body>
</html>