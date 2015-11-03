<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.store.Customer" import="java.sql.*" import = "com.store.DatabaseConnection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>Guest Customer</title>
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
         
         <br>

    <br><br>
    
    
 <%
                      
            Connection  conn=null;  
            conn = DatabaseConnection.getConnection();
            %> 
             
             <br>
           Products List 
    </h2>
        <table border="1">
            <tr>
                <th><font size='4' color="white">ProductId</font></th>
                <th><font size='4' color="white">ProductCode</font></th>
                <th><font size='4' color="white">Brand</font></th>
                <th><font size='4' color="white">Name</font></th>
                <th><font size='4' color="white">ProductType</font></th>
                <th><font size='4' color="white">Price</font></th>
                
            </tr>
        <%
            Statement stm1 = conn.createStatement();
        
            String s1 = "SELECT * FROM Products ";
            ResultSet r1 = stm1.executeQuery(s1);
            while ( r1.next() )
             { 
                 out.print("<tr>");
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+ r1.getString ("ProductId") + "</font>"+"</center>"+"</td>" ); 
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+ r1.getString ("ProductCode") +"</font>"+"</center>"+ "</td>");
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+ r1.getString ("Brand") + "</font>"+"</center>"+"</td>" ); 
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+ r1.getString ("Name") +"</font>"+"</center>"+ "</td>");
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+ r1.getString ("ProductType") + "</font>"+"</center>"+"</td>" ); 
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+ r1.getInt("Price") +"</font>"+"</center>"+ "</td>");
                 out.print("</tr>");
             }
         %>     
        </table>
           
      </center>     
</body>
</html>