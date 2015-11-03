<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Customer Sign Up</title>
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
<br><center>

 <form action="SignUpServlet" >
 <h2>New Customer???</h2>
 <h2>Sign Up here!</h2>
<br><br><br>
		   <table>
		   <tr>
				<td><font size='4' color="white"><label for="CustomerName">Name</label></font></td>
				<td><input type="text" name="CustomerName" required="required" size= "35"/></td>		
		    </tr>
		    
		   <tr>
			   <td><font size='4' color="white"><label for="CustomerPassword">Password</label></font></td>		
			   <td> <input type="password" name="CustomerPassword" size= "35" required="required"/></td>
		   </tr>
			
			<tr>
			   <td><font size='4' color="white"><label for="CustomerAddress">Mailing Address &nbsp; &nbsp;</label></font></td>		
			   <td><input type="text" name="Address" size= "35" /></td>	
			</tr>
			
			<tr>
			    <td><font size='4' color="white"><label for="CustomerEmailId">Email Id</label></font></td>
				<td><input type="email" name="EmailID" size= "35" /></td>
			</tr>
			
			<tr>
			    <td><font size='4' color="white"><label for="CustomerContactNum">Contact #</label></td>
				<td><input type="text" name="ContactNumber" size= "35"/></td>
			</tr>
			
			<tr>
			<td>   </td>
		
			<td><font size='4' color="white"><input type="submit" value="SIGN UP" class="submit_btn"></td>
			</tr>	
		    </table>	
		</form>
		</center>
		

	
</body>
</html>