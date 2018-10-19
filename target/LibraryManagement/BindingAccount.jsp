<%@page import="java.util.List"%>
<%@page import="com.niit.dao.AdminDao"%>
<%@page import="com.niit.model.User"%>
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
			<h3>Bind Account Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
  <div id="bindaccount">
  <% List<User> list=AdminDao.QueryAllUserwithoutAccount();%>



<table>
<tr>
<th>UserName</th>
<th>Gender</th>
<th>Tel</th>
<th>Balance/Bind</th>


</tr>
<%for(User user:list){ %>
<tr>
<td><input type="text" value="<%=user.getName() %>"></td>
<td><input type="text" value="<%=user.getGender() %>"></td>
<td><input type="text" value="<%=user.getTel() %>"></td>
<td>
<form action="<%=UrlConstant.Admin_SERVLET %>" method="post">

<input type="text" name="balance">

<input type="hidden" name="userid" value="<%=user.getId() %>">
<input type="submit" name="submit" value="bindingaccount"></form></td>

</tr>
<%} %>
</table>
  
  
  </div>

</body>
</html>