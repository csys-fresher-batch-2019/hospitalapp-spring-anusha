<%@page import="java.util.ArrayList"%>
<%@page import="com.anusha.hospitalApp.model.Doctors"%>
<!DOCTYPE html >
<html>
<head>
<title>Doctors list</title>
</head>
<body>
<jsp:include page="AdminNavBar.jsp"></jsp:include>
<jsp:include page="Design.jsp"></jsp:include>

<h2><center><font color=blue>Doctors Details</font></center></h2>
<%ArrayList<Doctors> a= (ArrayList)request.getAttribute("output");
%>
<center><table border="1"></center>
<thead><tr><th><center>Doctor Id </center></th> <th><center>Doctor Name</center> </th> <th><center>Department Id</center> </th> <th><center>Active</center> </th> <th><center>Present</center> </th> <th><center>Phone number</center> </th> <th><center>Gender</center> </th> <th><center>Number of Appointments</center> </th></tr></thead>
<tbody>
<%

for (Doctors doc : a) {%>

	<tr>	
	<td><%= doc.getDoctorId()%>
	<td><%=doc.getDoctorName()%>
	<td><%=doc.getDepartmentId()%>
	<td><%=doc.getActive()%>
	<td><%=doc.getDoctorPresent()%>
	<td><%=doc.getdPhoneNumber()%>
	<td><%=doc.getdGender()%>
	<td><%=doc.getNoOfAppointment()%>
	</tr>
<%}
%>
</body>
</html>