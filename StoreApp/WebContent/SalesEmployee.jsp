<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" import = "com.store.DatabaseConnection" import = "com.store.Employee"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	
		<div id="templatemo_social">
        
        </div> <!-- end of social -->
 <center>
            <% Employee currentUser = (Employee) (session.getAttribute("currentSessionUser"));%>
			
          <font size="5" color=white> Welcome <%= currentUser.getFirstName()  %>!!!</font>
      
 <%                
            Connection  conn=null;  
            conn = DatabaseConnection.getConnection();
            %> 

<form name="main0" >
<br><br>
        <label for=ProductId><font size='4'>Product Id</font> </label>
			<input type="text" name="ProductId"/><br><br>
	<input type="submit"  class="submit_btn" value="VIEW PRODUCT DETAILS">	
	<br>
    <br>
      <table border=2>
            <tr>
                <th><font size="2" color="white">ProductId</font></th>
                <th><font size="2" color="white">ProductCode></font></th>
                <th><font size="2" color="white">DepartmentId</font></th>
                <th><font size="2" color="white">Brand</font></th>
                <th><font size="2" color="white">Name</font></th>
                <th><font size="2" color="white">ProductType</font></th>
                <th><font size="2" color="white">Price</font></th>
                <th><font size="2" color="white">ExpirationDate</font></th>
                <th><font size="2" color="white">Discount</font></th>
                <th><font size="2" color="white">ManufacturingDate</font></th>
            </tr>
        <% String ProductId = request.getParameter("ProductId");
            Statement stm = conn.createStatement();
        String cus = "SELECT * FROM Products WHERE ProductId = '" + ProductId + "'";
        ResultSet r = stm.executeQuery(cus);
        
            while ( r.next() )
             { 
                 out.print("<tr>");
                 out.print("<td>" +  r.getString ("ProductId") + "</td>" ); 
                 out.print("<td>" +  r.getString ("ProductCode") + "</td>");
                 out.print("<td>" +  r.getString ("DepartmentId") + "</td>" ); 
                 out.print("<td>" +  r.getString ("Brand") + "</td>");
                 out.print("<td>" +  r.getString ("Name") + "</td>" ); 
                 out.print("<td>" +  r.getString ("ProductType") + "</td>");
                 out.print("<td>" +  r.getString ("Price") + "</td>" ); 
                 out.print("<td>" +  r.getString ("ExpirationDate") + "</td>");
                 out.print("<td>" +  r.getString ("Discount") + "</td>");
                 out.print("<td>" +  r.getString ("ManufacturingDate") + "</td>");
                // out.print("<td><a href='update.jsp?id=" +  r.getString ("ProductId") + "'>Update</a></td>");


                 out.print("</tr>");
             }
         %> 
          
        </table>
     <br>
     <br>
     </form>
       
    <form name="DeleteInventory" action="DeleteServlet" method = "get"><%-- ??change?? --%>
			 <h3>Delete Product</h3>
			<table>
			<tr>
						<td><label for=ProductId><font size='4'>Product Id</font> </label></td> 		
						<td><input type="text" name="ProductId" /><br></td>
			</tr>
						
							
			<tr>	
						<td colspan="2" align="center"><input type="submit" class="submit_btn" value="DELETE"></td>
						
			</tr>	
			</table>	
	</form>
    
    
    <br>
 
  
	<form name="UpdateInventory" action="UpdateProduct.jsp" method = "get"><%-- ??change?? --%>
     <font size="4" color="white">To Update Product.. &nbsp; Click here ->&nbsp;</font>
    <input type="submit" class="submit_btn" value="UPDATE PRODUCT">
    </form>
 <br>
    
    <form name="main0" action="SalesEmployeeOrder.jsp" method="get">
    <font size="4" color="white">To Place Order.. &nbsp; Click here ->&nbsp;</font>
        <input type="submit" class="submit_btn" value=" PLACE ORDER"></form>
       </center>
    
        </body>
</html>
