<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import = "com.store.DatabaseConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Sales Employee</title>
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
<%!
Object price;

%>
     <center>
            <%  price = (session.getAttribute("Price"));%>
			
            
        
		
			
			
<form  id = "form1" action = "SalesEmployeeOrderServlet">
<br><br><br>
<table>
<tr>
		<td><label for="ProductId"><font size="3" color="white"> Product Id </font></label>	&nbsp; &nbsp;</td>	
		<td>	<input type="text" name="ProductIdE"/>	<br></td>
</tr>
			
	<tr>		
	        <td>  <label for="CustomerId" > <font size="3" color="white">Customer Id &nbsp; &nbsp;</font> </label>	</td> 		
			<td><input type="text" name="CustomerIdE"/><br></td>
			
	</tr>
	</table>		
			<input type="submit" value="Place Order" class="submit_btn"><br><br>	
		<br><br><font size="3" color="white">Your current total bill amount is <%=price %> dollars</font>
		</form><br> 
		<br> 
		
		
		<form action = "SalesEmployee.jsp"><input type = "submit" value = "My Page" class="submit_btn"></form>
		<br><br>
		</center>
		
		<br><br>	
</body>
</html>
