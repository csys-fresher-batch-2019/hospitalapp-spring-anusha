<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Patient Registration</title>
<body>
<form action = PatientRegister>
<style>
body {
  background-color: lightblue;
}
button {
 background-color:pink;
}
</style>
<jsp:include page="Design.jsp"></jsp:include>
<right> <a href="Home.jsp" class="button">Home</a></right>
<h2><center><font color=blue>User Registration</font></center></h2>
<h3 align="center"><font color=blue>Fill the details for registration</font></h3>
<br/>
<center><font color=blue>Enter Name :  </font><input type="name" name="name" 
placeholder="Enter Name" required autofocus/></center>
<br/>
<center><font color=blue>Enter Age :  </font><input type="number" name="age" 
placeholder="Enter Age" required/></center>
<br/>
<center><font color=blue>Gender:  </font><input type="radio" name="gender" required value="M" > <font color=blue>Male</font>
<input type="radio" name="gender" required value="F" > <font color=blue>Female</font></center>
<br/>
<center><font color=blue>Enter Address :  </font><input type="text" name="address" 
placeholder="Enter Address" required/></center>
<br/>
<center><font color=blue>Enter PhoneNumber :  </font><input type="text" name="phNo" 
placeholder="Enter PhoneNumber" required maxlength ="10" pattern ="\d{10}" title= "Enter 10 digits"/></center>
<br/>
<center><font color=blue>Enter Password:  </font><input type="password" name="password" required /></center>
<br/>
<form action = "PatientFeatures.jsp">
<center><button class="button">NEXT</button></center>
</form>
</body>
</html>