<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.store.Employee" import="java.sql.*" import = "com.store.DatabaseConnection"%>

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
		
        
	<form name="UpdateInventory" action="UpdateServlet" method = "get"><%-- ??change?? --%>
    <center>
     <h3>Update Product</h3>
    	<table>
			<tr>
						<td><label for=ProductId><font size='4' color="white">Product Id</font> </label></td> 		
						<td><input type="text" name="ProductId" /><br></td>
			</tr>
						
			<tr>
						<td><label for=ProductCode><font size='4' color="white">Product Code</font> </label></td> 		
						<td><input type="text" name="ProductCode" required="required"/></td>
			</tr>
			
			<tr>
						<td><label for=DepartmentId><font size='4' color="white">Department Id</font> </label></td> 		
						<td><input type="text" name="CustomerName" required="required"/></td>
			</tr>
			
			<tr>
						<td><label for=Brand><font size='4' color="white">Brand</font> </label></td>
						<td><input type="text" name="Brand" required="required"/></td>
			</tr>
			<tr>			
						<td><label for=Name><font size='4' color="white"> Name</font> </label></td>
						<td><input type="text" name="Name" required="required"/> </td>
			</tr>	
			<tr>		
						<td><label for=ProductType><font size='4' color="white"> Product Type</font> </label></td>
						<td><input type="text" name="ProductType" required="required"/> </td> 		
						
			</tr>
			<tr>		
						<td><label for=Price><font size='4' color="white">Price</font> </label></td>
						<td><input type="text" name="Price" required="required"/></td>
			</tr>
			<tr>			
						<td><label for=ExpirationDate><font size='4' color="white">Expiration Date</font> </label></td>
						<td><input type="text" name="ExpirationDate" required="required"/></td>
			</tr>
			<tr>			
						<td><label for=Discount><font size='4' color="white">Discount</font> </label></td>
						<td><input type="text" name="Discount" required="required"/></td>
			</tr>
			<tr>			
						<td><label for=ManufacturingDate><font size='4' color="white">Manufacturing Date</font> </label></td>
						<td><input type="text" name="ManufacturingDate" required="required"/></td>
			</tr>				
			
			<tr>	
					<td colspan="2" align="center"><input type="submit" class="submit_btn" value="UPDATE"></td>
			</tr>			
				
			</table>
			<br>
			<br>
			</form>
	   
        <form name="main0" action="listInventory.jsp" method="get">
    <font size="4" color="white">To Return to your actions page &nbsp; Click here ->&nbsp;</font>
        <input type="submit" class="submit_btn" value=" MY PAGE"></form>
       
	  </center>			
	

	</body>
	</html>