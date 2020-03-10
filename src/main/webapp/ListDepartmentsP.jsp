<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Departments"%>
</head>
<body>
	<jsp:include page="PatientNavBar.jsp"></jsp:include>
<html>
<jsp:include page="Design.jsp"></jsp:include>
<title>List Departments</title>
<h3>
	<center>
		<font color=blue>List Departments</font>
	</center>
</h3>
<center>
	<table border="1">
		</center>
		<thead>
			<tr>
				<th><center>Department Id</center></th>
				<th><center>Department Name</center></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${output}" var="departments">
				<tr>
					<td>${departments.departmentID}</td>
					<td>${departments.departmentName}</td>
			</c:forEach>
		</tbody>
	</table>
	</form>
	</body>
</html>