<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<%session.invalidate(); %>
<form action="StoreServlet">
<br><center><h2>Warehouse Application</h2></center>
<br><h2>If you are a customer already, sign in. Else Sign up below</h2>

			Please enter your username 		
			<input type="text" name="CustomerName"/><br>		
		
			Please enter your password
			<input type="text" name="CustomerPassword"/><br>
			
			<input type="submit" value="submit">			
		
		</form><br>
		<DIV ALIGN="left"><form name="main0" action="SignUp.jsp" method="get">
        <input type="submit" value="SIGN UP CUSTOMER">
    </form></DIV>
    <br>
<br>If you are an Employee, click this button
<DIV ALIGN="left"><form name="main0" action="Employee.jsp" method="get">
        <input type="submit" value=" Employee Login">
    </form></DIV>
</body>
</html>