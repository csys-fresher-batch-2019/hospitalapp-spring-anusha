<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: "Lato", sans-serif;
}

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #FFFFFF;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: blue;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="AddDepartments.jsp">Add Departments</a>
  <a href="ViewDepartmentDetailsServlet">View Department Details</a>
  <a href="DeleteDepartments.jsp">Delete Departments</a>
  <a href="ViewAllDoctorsServlet">View All Doctors</a>
  <a href="ViewDoctorsPresentServlet">Doctors Present</a>
  <a href="SearchDoctorByName.jsp">Search Doctors By Name</a>
  <a href="DeactivateDoctorProfile.jsp">Deactivate Doctor Profile</a>
  <a href="ViewAllPatientsServlet">View All Patients</a>
  <a href="SearchPatientById.jsp">Search Patient By Id</a>
  <a href="ViewAllAppointmentsServlet">View All Appointments</a>
  <a href="DoctorAppointments.jsp">Doctor's Appointments</a>
  <a href="PatientAppointments.jsp">Patient's Appointments</a>
  <a href="AdminLogin.jsp">Logout</a>
</div>

<div id="main">
  <font color="blue"><span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;open</font></span>
</div>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "400px";
  document.getElementById("main").style.marginLeft = "400px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>
   
</body>
</html> 
