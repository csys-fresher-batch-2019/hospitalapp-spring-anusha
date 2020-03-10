<%@page import="java.util.ArrayList"%>
</head>
<body>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<!DOCTYPE html>
<%@page import="com.anusha.hospitalApp.model.Departments"%>
<html>
<title>List Departments</title>
<h3><center><font color="blue">List Departments</font></center></h3>
<jsp:include page="Design.jsp"></jsp:include>
<%ArrayList<Departments> a= (ArrayList)request.getAttribute("output"); %>
<center><table border="1"></center>
<thead><tr><th><center>Department Id </center></th> <th><center>Department Name</center> </th><th><center>Active</center></th></tr></thead>
<tbody>
<%
for (Departments dept : a) {%>

	<tr>	
	<td><%= dept.getDepartmentID()%>
	<td><%=dept.getDepartmentName()%>
	<td><%=dept.getActive()%>
	</tr>
<%}
%>
</tbody>
</table>
</form>
</body>
</html>