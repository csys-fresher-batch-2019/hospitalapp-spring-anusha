<%@page import="com.anusha.hospitalApp.model.Departments"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
</head>
<body>
<jsp:include page="DoctorNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<title>List Departments</title>
<h3><center><font color = blue>List Departments</font></center></h3>
<% ArrayList<Departments> list = (ArrayList)request.getAttribute("output");
%> 
<center><table border="1"></center>
<thead><tr><th><center>Department Id </center></th> <th><center>Department Name</center> </th></tr></thead>
<tbody>
<%
for (Departments dept : list) {%>

	<tr>	
	<td><%= dept.getDepartmentID()%>
	<td><%=dept.getDepartmentName()%>
	</tr>
<%}
%>
</tbody>
</table>
</body>
</html>