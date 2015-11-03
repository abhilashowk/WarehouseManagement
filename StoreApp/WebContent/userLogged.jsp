<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.store.Customer" import="java.sql.*" import = "com.store.DatabaseConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>User Logged In</title>
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
<%!
String name;

%>
  
     <br>       <% Customer currentUser = (Customer) (session.getAttribute("currentSessionUser"));%>
			
           <h3> Welcome <%name = currentUser.getCustomerName();  %>  <%out.println(name); %>!!</h3>
    

    
    
 <%
                      
            Connection  conn=null;  
            conn = DatabaseConnection.getConnection();
            %> 
             
             
          <h3> Available products </h3>
  
        <table border="1">
            <tr>
                <th><font size="2" color="white">Product Id</font></th>
                <th><font size="2" color="white">Product Code</font></th>
                <th><font size="2" color="white">Brand</font></th>
                <th><font size="2" color="white">Name</font></th>
                <th><font size="2" color="white">Product Type</font></th>
                <th><font size="2" color="white">Price</font></th>
                
            </tr>
        <%
            Statement stm1 = conn.createStatement();
        
            String s1 = "SELECT * FROM Products ";
            ResultSet r1 = stm1.executeQuery(s1);
            while ( r1.next() )
             { 
                 out.print("<tr>");
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" +  r1.getString ("ProductId") +"</font>"+"</center>"+ "</td>" ); 
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" +  r1.getString ("ProductCode") +"</font>"+"</center>"+ "</td>");
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" +  r1.getString ("Brand") + "</font>"+"</center>"+"</td>" ); 
                 out.print("<td>"+"<center>"+ "<font size=2 color= white>"  +  r1.getString ("Name") + "</font>"+"</center>"+"</td>");
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" +  r1.getString ("ProductType") +"</font>"+"</center>"+ "</td>" ); 
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" +  r1.getInt("Price") +"</font>"+"</center>"+ "</td>");
                 out.print("</tr>");
             }
         %>     
        </table>
        <br>
   <DIV ALIGN="center"><form name="main0" action="order.jsp" method="get">
        <input type="submit" class="submit_btn" value=" Place Order">
    </form></DIV>
    <br><br>
       <h3>Your previous orders </h3>
 
        <table border=2>
            <tr>
                <th><font size="2" color="white">Order ID </font></th>
                <th><font size="2" color="white">Product ID </font></th>
                <th><font size="2" color="white">Date Of Order </font></th>
                <th><font size="2" color="white">Billing Amount </font></th>
               
            </tr>
        <%
            Statement stm = conn.createStatement();
        String cus = "SELECT CustomerID FROM Customer where CustomerName = '" + name + "'";
        ResultSet res = stm.executeQuery(cus);
        
        String ID = "";
        while ( res.next() )
        { 
        ID =  res.getString("CustomerID");
        }
        session.setAttribute("key", ID);
            String s = "SELECT * FROM Orders WHERE CustomerID = '" + ID + "'";
            ResultSet r = stm.executeQuery(s);
            while ( r.next() )
             { 
                 out.print("<tr>");
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" +r.getString ("OrderID") +  "</font>"+"</center>"+"</td>" ); 
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" + r.getString ("ProductID") + "</font>"+"</center>"+"</td>");
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" + r.getString ("DateOfOrder") +"</font>"+"</center>"+ "</td>" ); 
                 out.print("<td>" +"<center>"+ "<font size=2 color= white>" + r.getString ("BillingAmount") +"</font>"+ "</center>"+"</td>");
                 out.print("</tr>");
             }
         %>     
        </table>

         
   </center>      
</body>
</html>