<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctors And Departments</title>
</head>
<body>
	<jsp:include page="DoctorNavBar.jsp"></jsp:include>
	<jsp:include page="Design.jsp"></jsp:include>
	<h2>
		<center>
			<font color=blue>List of Doctors and their Departments</font>
		</center>
		</h1>
		<center>
			<table border="1">
				</center>
				<thead>
					<tr>
						<th><center>Doctor Name</center></th>
						<th><center>Doctor Id</center></th>
						<th><center>Department Name</center></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${output}" var="doctors" >
						<tr>
							<td>${doctors.name}</td>
							<td>${doctors.id}</td>
							<td>${doctors.department.name}</td>
					</c:forEach>
				</tbody>
			</table>
</body>
</html>