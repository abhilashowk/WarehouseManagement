<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import = "com.store.DatabaseConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Order</title>
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
<body>
	<div id="templatemo_social">
	      <a href="Main.jsp">  <img src="images/home2.png" align="right" width="50px" height="50px" ></img></a>
	</div> <!-- end of social -->
<%!
Object price;

%>
     <center>
            <%  price = (session.getAttribute("Price"));%>
   <br><br>      
		 
		<font size="4"  color="white">	Customer ID <%= session.getAttribute("key")  %> </font>
<form  id = "form1" action = "OrderServlet">
<br><br><br><font size="4"  color="white">Please enter product id</font> &nbsp; &nbsp;	
			<input type="text" name="ProductId"/>	
			
			<% String fname = request.getParameter("ProductId");
			Connection  conn=null;  
            conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select ProductId, ProductCode, Price from products where ProductId = '" + fname  + "'");
%>

			<TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0 >
			<%
while(rs.next())
{
%><option><tr>
<%=rs.getString("ProductId") %> </tr><tr>
<%=rs.getString("ProductCode")%>
<%
}
%></tr></option>
	             
			</TABLE>
			<br>
			<%String ns = session.getAttribute("key").toString();  %> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%session.setAttribute("key", ns); %>
			<input type="submit"  class="submit_btn" value="Place Order"><br><br>	
		<br><br><font size="4"  color="white">Your current total bill amount is &nbsp;  <%=price%> dollars</font>
		</form><br> 
		
		<form action = "userLogged.jsp"><input type = "submit"  class="submit_btn" value = "My Page"></form>
		<br><br>
		  </center>		
</body>
</html>