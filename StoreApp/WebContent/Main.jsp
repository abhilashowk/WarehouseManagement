<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width" />
<title>The Shopppeee</title>

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

<div id="slider">
	<div id="templatemo_wrapper">

		<div id="templatemo_social">
      <a href="Main.jsp">  <img src="images/home2.png" align="right" width="50px" height="50px" ></img></a>
        </div> <!-- end of social -->
        
        <div id="templatemo_main">
        	<div id="templatemo_sidebar">
		    <%@include file='sidebar.jsp'%>
            </div> <!-- end of sidebar -->
      
			
            <div id="templatemo_content">
            	<div class="scroll">
	        		<div class="scrollContainer">
                    
                    <div class="panel" id="home">
                       <%@include file='panelHome.jsp'%>
                    </div> <!-- end of home -->
                    
                    <div class="panel" id="login">
                       <%@include file='Login.jsp'%>
                    </div><!-- end of login -->
                    
                    <div class="panel" id="listInventory">
                       <%@include file='listInventory.jsp'%>
                    </div><!-- end of login -->
                    
                    <div class="panel" id="aboutus">
                         <%@include file='aboutUs.jsp'%>                     
                    </div> <!-- end of about us -->
                    
                    <div class="panel" id="services">
                         <%@include file='services.jsp'%>                    
                    </div> <!-- end of services -->
                                       
                    <div class="panel" id="blog">
                        <%@include file='panelBlog.jsp'%>                        
                    </div> <!-- end of gallery -->
                    
                    <div class="panel" id="contactus">
                         <%@include file='contactUs.jsp'%>	                       
                    </div> <!-- end of contact us -->
                    
                    
                    <div class="panel" id="signUp">
                         <%@include file='SignUp.jsp'%>                    
                    </div> <!-- end of signUp -->
                    
                     
                    
                    </div> <!-- end scrollContainer -->
				</div><!-- end of scroll -->
            </div> <!-- end of content -->
            
            <div class="cleaner"></div>
        </div> <!-- end of main -->
    
    	<div id="templatemo_footer">
			<%@include file='footer.jsp'%>           
		</div>       
        
    </div> <!-- end of wrapper -->
</div> <!-- end of slider -->
</body>
</html>