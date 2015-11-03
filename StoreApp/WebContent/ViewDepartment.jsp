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
<form name="main0">
   <center>
        <label for=DepartmentId><font size='4' color="white"
        >Department Id</font> </label><br><br>
        <%  Connection  conn1=null;  
            conn1 = DatabaseConnection.getConnection();%>
			<input type="text" name="DepartmentId"/><br><br>
	<input type="submit"  value="View Department" class="submit_btn">	<br>
	<br>

        <table border="1">
            <tr>
                <th>Department Id</th>
                <th>Department Name</th>
                <th>Manager Id</th>
            </tr>
        <%
        	String DepartmentId= request.getParameter("DepartmentId");
            Statement stm1 = conn1.createStatement();
        
            String s1 = "SELECT * FROM departments where DepartmentId= '" + DepartmentId + "'";
            ResultSet r1 = stm1.executeQuery(s1);
            while ( r1.next() )
             { 
                 out.print("<tr>");
                 //out.print("blah blah!");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+  r1.getString ("DepartmentId")+"</font>"+"</center>"+ "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+  r1.getString ("DepartmentName")+"</font>"+"</center>" + "</td>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+  r1.getString ("ManagerId")+"</font>" +"</center>"+ "</td>" ); 
                 out.print("</tr>");
             }
         %>     
        </table>

</center>
</form>
<br>
			<br>
			     <form name="main0" action="Manager.jsp" >
    <font size="4" color="white">To Return to your actions page &nbsp; Click here ->&nbsp;</font>
        <input type="submit" class="submit_btn" value=" MY PAGE"></form>

</body>
</html>