<%@page import="com.niit.constants.MessageConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Error Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Error Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<link href="//fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
</head>
<body>
	<div class="main">
		<h1>Error Page</h1>
		<div class="w3layouts_main_grids">
			<div class="w3_main_grid_left">
				
				
			</div>
			<div class="w3_main_grid_right w3_agileits_grid_right">
				<h3 style="color:red;">Something Wrong happened</h3>
				<p style="color:purple">The Reason maybe as follow:</p>
			    <%if(request.getAttribute(MessageConstant.message1)!=null) {%>
			    <p style="color:green"><%=request.getAttribute(MessageConstant.message1) %></p>
			    <%} %>
			    
			     <%if(request.getAttribute(MessageConstant.message2)!=null) {%>
			    <p style="color:green"><%=request.getAttribute(MessageConstant.message2) %></p>
			    <%} %>
			    
			     <%if(request.getAttribute(MessageConstant.message3)!=null) {%>
			    <p style="color:green"><%=request.getAttribute(MessageConstant.message3) %></p>
			    <%} %>
			    
			     <%if(request.getAttribute(MessageConstant.message4)!=null) {%>
			    <p style="color:green"><%=request.getAttribute(MessageConstant.message4) %></p>
			    <%} %>
			    
			    
			    
			    
			    
			    
			    

                <h6 style="color:blue;">Please try again after sometime</h6>
			    
			</div>
			<div class="clear"> </div>
		</div>
		<div class="agileits_copyright">
			<p> © All Rights Reserved | Design by HuaXia Library</p>
		</div>
	</div>
</body>
</html>