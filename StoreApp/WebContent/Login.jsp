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
      
<%session.invalidate(); %>
 <form action="StoreServlet"> 
<br><center><h4>Warehouse Application</h4></center>
<br><center><h4>If you are a customer already, sign in.</br>Else Sign up below</h4></center>
<center>
<table>
	<tr>
		<td>		<label for=customerName><font size='4'>Customer Name </font> </label></td>
		<td></td>
		<td>		<input type="text" name="CustomerName"/><br>		</td>
	</tr>
	
	<tr>
		<td>		<label for=customerName><font size='4'>Password</font></label></td>
		<td></td>
		<td>		<input type="password" name="CustomerPassword"/></td>
	</tr>
			
	<tr>
	<td></td>
	<td>		<input type="submit" class="submit_btn" value="submit"></td>
		</tr>		
</table>
 </form> 
 </center>

		<br>
		<DIV ALIGN="left">
			<form name="main0" action="SignUp.jsp" method="get">	
	        <a href="#signUp"></a><input type="submit" class="submit_btn" value="SIGN UP CUSTOMER">
	        </form>
        </DIV>
    <br>
	
	<DIV ALIGN="left">
		<form name="main0" action="employeeLogin.jsp" method="get">
		   <input type="submit" class="submit_btn" value=" EMPLOYEE LOGIN"> 
		</form>
	</DIV>
  
    
        

</body>
</html>