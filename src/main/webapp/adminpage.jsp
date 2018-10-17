<%@page import="com.niit.model.Book"%>
<%@page import="com.niit.model.User"%>
<%@page import="com.niit.constants.MessageConstant"%>
<%@page import="com.niit.dao.AdminDao"%>
<%@page import="com.niit.constants.UrlConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/adminStyle.css" rel="stylesheet" type="text/css" />

<title></title>
<script type="text/javascript" src="js/jquery1.js"></script>
<link href="css/adminStyle1.css" rel="stylesheet" type="text/css" />


</head>
<body>

	<div class="top1">
		<marquee scrollAmount=2 width=300>数据无价，请谨慎操作！</marquee>
	</div>
	<div class="top2">
		<div class="logo">
			<img src="images/admin_logo.png" title="在哪儿" />
		</div>
		<div class="title" >
			<h3>HuaXia Library Adminstrator Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>

	<div class="left">
		<div class="div1">
			
			<div class="left_top">
				<img src="images/bbb_01.jpg"><img src="images/bbb_02.jpg"
					id="2"><img src="images/bbb_03.jpg"><img
					src="images/bbb_04.jpg">
			</div>
			
            <div class="div2">
				
		     <form action=<%=UrlConstant.Admin_SERVLET %> method="post"><input type="submit" name="submit" value="ManageUser"></form>
			</div>
			
			<div class="div2">
			<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="AddPublisher"></form>
		       
			</div>
		
			<div class="div2">
		   <form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="ManagePublisher"></form>
			</div>
			
			 <div class="div2">
				<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="AddBookType"></form>
		         
			</div>
			
			<div class="div2">
				<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="ManageBookType"></form>
			</div>
		
		    <div class="div2">
				<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="AddBook"></form>
		         
			</div>
			
			<div class="div2">
				<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="ManageBook"></form>
			</div>
		
			<div class="div2">
			<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="BindingAccount"></form>
			</div>
			
			<div class="div2">
			<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="ManageAccount"></form>
			</div>
			
			<div class="div2">
			<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="AddStock"></form>
			</div>
			
			<div class="div2">
			<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="ManageBorrowRequest"></form>
			</div>
			
			<div class="div2">
			<form action=<%=UrlConstant.Admin_SERVLET%> method="post"><input type="submit" name="submit" value="ManageReserveRequest"></form>
			</div>
			
			
		</div>
	</div>

	<div class="right">
		<div><h1 style="color:blue;font-size:28px;">Library Status</h1></div>
		<div id="status">
		<table>
		<tr>
		<th>User Quantity</th>
		<td><%=AdminDao.QueryAllUser().size() %></td>
		</tr>
		
		<tr>
		<th>Book Quantity</th>
		<td><%=AdminDao.QueryBook().size() %></td>
		</tr>
		
		<tr>
		<th>Publisher Quantity</th>
		<td><%=AdminDao.QueryAllPublisher().size() %></td>
		</tr>
		
		</table>
		</div>
		<hr>
		
	</div>

    





</body>
</html>
