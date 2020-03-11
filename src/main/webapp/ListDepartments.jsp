<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<html>
<title>List Departments</title>
<jsp:include page="Design.jsp"></jsp:include>
<h3>
	<center>
		<font color=blue>List Departments</font>
	</center>
</h3>
<body>
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
						<td>${departments.id}</td>
						<td>${departments.name}</td>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>