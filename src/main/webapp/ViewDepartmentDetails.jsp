<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
</head>
<body>
	<jsp:include page="AdminNavBar.jsp"></jsp:include>
	<!DOCTYPE html>
	<%@page import="com.anusha.hospitalApp.model.Departments"%>
<html>
<title>List Departments</title>
<h3>
	<center>
		<font color="blue">List Departments</font>
	</center>
</h3>
<jsp:include page="Design.jsp"></jsp:include>
<center>
	<table border="1">
		</center>
		<thead>
			<tr>
				<th><center>Department Id</center></th>
				<th><center>Department Name</center></th>
				<th><center>Active</center></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${output}" var="departments">
					<tr>
						<td>${departments.id}</td>
						<td>${departments.name}</td>
						<td>${departments.active}</td>
				</c:forEach>
		</tbody>
	</table>
	</form>
	</body>
</html>