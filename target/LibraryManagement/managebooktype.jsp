<%@page import="java.util.List"%>
<%@page import="com.niit.dao.AdminDao"%>
<%@page import="com.niit.model.Type"%>
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
			<h3>Book Management Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
  <div id="managebooktype">
  <% List<Type> list=AdminDao.QueryAllBookType();
   int sno=1;
%>



<table>
<tr>
<th>SNO</th>
<th>TypeName</th>
<th>ReleasingType</th>
<th>CreateDate</th>
<th>State</th>
</tr>
<% for(Type type:list) {%>
<tr>
<td><%=sno++ %></td>
<td><input type="text" name="typename" value="<%=type.getName() %>"></td>
<td><input type="text" name="releasingtype" value="<%=type.getReleasingtype() %>"></td>
<td><input type="text" name="time"  value="<%=type.getTime() %>"></td>
<td><%if(type.getFlag()==1){ %>Active<%}else{ %>Block<% } %></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" ><input type="submit" name="submit" value="AddBookType"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=type.getId() %>">
<input type="submit" name="submit" value="EditBookType"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=type.getId() %>">
<input type="submit" name="submit" value="DeleteBookType"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=type.getId() %>">
<input type="submit" name="submit" value="ChangeBookTypeState"></form></td>
</tr>
<% }%>
</table>
  
  
  
  
  </div>
</body>
</html>