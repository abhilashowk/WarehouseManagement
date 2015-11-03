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
        
<form >

<br>
<center>
<h2>Search Employee</h2>
 <label for=EmployeeId><font size='4'>Employee Id</font> </label>
        <%  Connection  conn5=null;  
            conn5 = DatabaseConnection.getConnection();%>
			<input type="text" name="EmployeeId"/><br><br>
			<input type="submit" class="submit_btn" value="Search Employee">
			</center>
</form>
			
			
			
			 </h2>
        <table border="1">'
            <tr font color="white">
                <th>EmployeeID</th>
                <th>FirstName</th>
                <th>MiddleName</th>
                <th>LastName</th>
                <th>Password</th>
                <th>SSN</th>
                <th>DOB</th>
                <th>JoiningDate</th>
                <th>Designation</th>
                <th>Salary</th>
                <th>ContactNum</th>
                <th>EmailId</th>
                <th>Address</th>
            </tr>
        <%
        	String EmployeeId= request.getParameter("EmployeeId");
            Statement stm = conn5.createStatement();
        		ResultSet r;
        		//String All=new String("all");
        	
            	String s = "SELECT * FROM employee WHERE EmployeeId= '" + EmployeeId + "'" ;
            	r = stm.executeQuery(s);
        	
            
            while ( r.next() )
             { 
                 out.print("<tr>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("EmployeeID") +"</font>"+"</center>"+  "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("FirstName") + "</font>"+"</center>"+ "</td>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("MiddleName") +"</font>"+"</center>"+  "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("LastName") + "</font>"+"</center>"+ "</td>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("Password") + "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("SSN") + "</font>"+"</center>"+ "</td>");
                 out.print("<td>" + "<center>"+"<font color= white size=2>"+  r.getString ("DOB") +"</font>"+"</center>"+  "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("JoiningDate") +"</font>"+"</center>"+  "</td>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+  r.getString ("Designation") +"</font>"+"</center>"+  "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("Salary") + "</font>"+"</center>"+ "</td>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("ContactNum") +"</font>"+"</center>"+  "</td>" ); 
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("EmailId") + "</font>"+"</center>"+ "</td>");
                 out.print("<td>" +"<center>"+"<font color= white size=2>"+   r.getString ("Address") +"</font>"+"</center>"+  "</td>");
                 out.print("</tr>");
             }
         %>     
        </table>
        
        <br>
        <br>
         <form name="main0" action="Manager.jsp" >
    <font size="4" color="white">To Return to your actions page &nbsp; Click here ->&nbsp;</font>
        <input type="submit" class="submit_btn" value=" MY PAGE"></form>
    </center>
	

</body>
</html>