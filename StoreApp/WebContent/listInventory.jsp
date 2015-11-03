<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" import = "com.store.DatabaseConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Inventory List</title>
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
<center>	

 <%
                      
            Connection  conn=null;  
            conn = DatabaseConnection.getConnection();
            %> 

<form name="main0" >
        <label for=ProductId><font size='4' color="white">Product Id &nbsp;</font> </label>
			<input type="text" name="ProductId"/><br>
	<input type="submit"  class="submit_btn" value="VIEW PRODUCT DETAILS">	
    </form>
    
    <br>
    <center>
				
    <table border=2>
            <tr>
                 <th><font color="white" size=4>ProductId</font></th>
                <th><font color="white" size=4>ProductCode</font></th>
                <th><font color="white" size=4>DepartmentId</font></th>
                <th><font color="white" size=4>Brand</font></th>
                <th><font color="white" size=4>Name</font></th>
                <th><font color="white" size=4>ProductType</font></th>
                <th><font color="white" size=4>Price</font></th>
                <th><font color="white" size=4>ExpirationDate</font></th>
                <th><font color="white" size=4>Discount</font></th>
                <th><font color="white" size=4>ManufacturingDate</font></th>
                
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
        </center>
	<br>
	<br>
	
    <h3>Delete Product</h3>
    <form name="DeleteInventory" action="DeleteServlet" method = "get"><%-- ??change?? --%>
			<table>
			<tr>
						<td><label for=ProductId><font size='4' color="white">Product Id&nbsp;</font> </label></td> 		
						<td><input type="text" name="ProductId" /><br></td>
			</tr>
						
							
			<tr>	
						<td colspan="2" align="center"><input type="submit" class="submit_btn" value="DELETE"></td>
						
			</tr>	
			</table>	
	</form>
	
	<br> 
    <br>
	 <form action="AddProduct.jsp">
	    <font size="4" color="white">To Add Product.. &nbsp; Click here ->&nbsp;</font>
	    <input type="submit" class="submit_btn" value="ADD PRODUCT">
	</form>
    <br>
    <br>
	
	<form name="UpdateInventory" action="UpdateProductIM.jsp" method = "get"><%-- ??change?? --%>
     <font size="4" color="white">To Update Product.. &nbsp; Click here ->&nbsp;</font>
    <input type="submit" class="submit_btn" value="UPDATE PRODUCT">
    </form>

    
    
   </center> 
</body>
</html>
