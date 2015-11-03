<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.store.Employee" import="java.sql.*" import = "com.store.DatabaseConnection"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Add Employee</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/coda-slider.css" type="text/css" charset="utf-8" />

<script src="js/jquery-1.2.6.js" type="text/javascript"></script>
<script src="js/jquery.scrollTo-1.3.3.js" type="text/javascript"></script>
<script src="js/jquery.localscroll-1.2.5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.serialScroll-1.2.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/coda-slider.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	<div id="templatemo_social">
      <a href="Main.jsp">  <img src="images/home2.png" align="right" width="50px" height="50px" ></img></a>
        </div> <!-- end of social -->
        
<form name="addEmployee" action="ManagerFunctions" method = "get" ><%-- ??change?? --%>

<center>
<h2>Add Employee</h2>

        <%  Connection  conn2=null;  
            conn2 = DatabaseConnection.getConnection();%>
			<br>
			<table>
			<tr>
						<td><label for=EmployeeId><font size='4'  color="white">Employee Id</font> </label></td> 		
						<td><input type="text" name="EmployeeId" /><br></td>
			</tr>
						
			<tr>
						<td><label for=FirstName><font size='4'  color="white">First Name</font> </label></td> 		
						<td><input type="text" name="FirstName" required="required"/></td>
			</tr>
			
			<tr>
						<td><label for=MiddleName><font size='4'  color="white">Middle Name</font> </label></td> 		
						<td><input type="text" name="MiddleName" /></td>
			</tr>
			
			<tr>
						<td><label for=LastName><font size='4'  color="white">Last Name</font> </label></td>
						<td><input type="text" name="LastName" required="required"/></td>
			</tr>
			<tr>			
						<td><label for=Password><font size='4'  color="white"> Password</font> </label></td>
						<td><input type="password" name="Password" required="required"/> </td>
			</tr>	
			<tr>		
						<td><label for=SSN><font size='4'  color="white"> SSN</font> </label></td>
						<td><input type="text" name="SSN" required="required"/> </td> 		
						
			</tr>
			<tr>		
						<td><label for=DOB><font size='4'  color="white">DOB</font> </label></td>
						<td><input type="text" name="DOB" /></td>
			</tr>
			<tr>			
						<td><label for=JoiningDate><font size='4'  color="white">Joining Date</font> </label></td>
						<td><input type="text" name="JoiningDate" /></td>
			</tr>
			<tr>			
						<td><label for=Designation><font size='4'  color="white">Designation</font> </label></td>
						<td><input type="text" name="Designation" required="required"/></td>
			</tr>
			<tr>			
						<td><label for=Salary><font size='4'  color="white">Salary</font> </label></td>
						<td><input type="text" name="Salary" /></td>
			</tr>				
			<tr>			
						<td><label for=ContactNum><font size='4'  color="white">Contact Number</font> </label></td>
						<td><input type="text" name="ContactNum" /></td>
			</tr>
			<tr>			
						<td><label for=EmailId><font size='4'  color="white">Email ID</font> </label></td>
						<td><input type="email" name="EmailId" /></td>
			</tr>
			<tr>			
						<td><label for=Address><font size='4'  color="white">Address</font> </label></td>
						<td><input type="text" name="Address" /></td>
			</tr>
			<tr>	
						<td colspan="2"><input type="submit" class="submit_btn" value="ADD"></td>
						
			</tr>	
			</table>	
			
			
			</center>
	</form>
	
	<br>
			<br>
			     <form name="main0" action="Manager.jsp" >
    <font size="4" color="white">To Return to your actions page &nbsp; Click here ->&nbsp;</font>
        <input type="submit" class="submit_btn" value=" MY PAGE"></form>
	

</body>
</html>