<html>
<body>
<h2>Hospital Management App</h2>
<h3>Registration</h3>
<form action = "next.jsp">
Enter Name : <input type = "text" name = "name"
placeholder = "Enter Name" required autofocus/>
<br/>
Enter Email : <input type="email" name="email"
required>
<br/>
Enter Password: 
<input type="password" name="password" required />
<br/>
Enter Date of Birth:
<input type="date" name="dob"min = "" />
<br/>
<button type = "submit ">Submit</button>
</form>
<h3>Features:</h3>
<ul>
<li> <a href="register.jsp">Register</a> </li>
<li> <a href="login.jsp">Login</a> </li>
</ul>
<input type="radio" name="gender" value="M" > Male
<input type="radio" name="gender" value="F" > Female 
Hobbies:
<input type="checkbox" name="hobbies" value="Cricket" > Cricket
<input type="checkbox" name="hobbies" value="Football" > Football
Select Movie
<select name="movie">
<option value="darbar" > Darbar </option>
<option value="sarkar" > Sarkar </option>
</select>
Display Movies:
<table border="1">
<thead><tr><th>#</th> <th>Movie Name </th> </tr>
<tbody>
<tr><td>1</td> <td>Darbar </td></tr>
<tr><td>2</td> <td>Sarkar </td></tr>
</tbody>
</table>
<img src="assets/images/darbar.jpg"
 width="100" height="100"
 alt="Darbar"/>
</body>
</html>
