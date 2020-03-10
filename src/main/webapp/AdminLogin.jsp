<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<center>
	<h1>
		<font color="blue">AdminLogin</font>
	</h1>
</center>
</head>
<title>AdminLogin</title>
<body>
	<jsp:include page="Design.jsp"></jsp:include>
	<form action="AdminLoginServlet">
		<right> <a href="Home.jsp" class="button">Home</a></right>
		<br> <br>
		<center>
			<font color="blue">User name: </font><input type="text"
				name="username" placeholder="Username" required autofocus />
		</center>
		<br> <br>
		<center>
			<font color="blue">Enter Password: </font><input type="password"
				name="password" required />
		</center>
		<br> <br>
		<center>
			<button type="submit" class="button">
				<center>Login</center>
			</button>
		</center>
	</form>
</body>
</html>
