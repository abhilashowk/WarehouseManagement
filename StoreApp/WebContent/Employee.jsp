<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Login</title>
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
	<form action="EmployeeServlet"> 
	<center>
	<h4>Warehouse Application</br> Employee SignIn </h4><br />
	
		<table>
			<tr>
				<td>		<label for=employeeName><font size='4'>UserName</font> </label></td>
				<td>		<input type="text" name="FirstName"/><br>		</td>
			</tr>
			
			<tr>
				<td>		<label for=employeePassword><font size='4'>Password</font></label></td>
				<td>		<input type="password" name="Password"/></td>
						
				<tr>
				<td></td>
				<td>		<input type="submit" class="submit_btn" value="submit">	</td>
			</tr>	
				
		</table>	
		</center>
	</form>


</body>
</html>