<%@page import="com.niit.service.AdminService"%>
<%@page import="java.util.List"%>
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
			<h3>User Management Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
<div id="manageuser">
<%List<User>list=(List<User>)AdminService.QueryAllUser(); 
  int sno=1;
%>
<table>
<tr>
<th>Sno</th>
<th>Name</th>
<th>Gender</th>
<th>Role</th>
<th>Tel</th>
<th>Location</th>
<th>Email</th>
<th>password</th>
<th>State</th>
<th>Add</th>
<th>Edit</th>
<th>Delete</th>
<th>ChangeState</th>
</tr>
<%for(User user:list){%>
<tr>
<td><%=sno++ %></td>
<td><%=user.getName() %></td>
<td><%=user.getGender() %></td>
<td><%=user.getRole() %></td>
<td><%=user.getTel()%></td>
<td><%=user.getLoc() %></td>
<td><%=user.getEmail() %></td>
<td><%=user.getPassword()%></td>
<td><%if(user.getFlag()==1){ %>Active<%}else{ %>Block<% } %></td>
<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" ><input type="submit" name="submit" value="AddUser"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=user.getId() %>">
<input type="submit" name="submit" value="Edituser"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=user.getId() %>">
<input type="submit" name="submit" value="Deleteuser"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=user.getId() %>">
<input type="submit" name="submit" value="ChangeUserState"></form></td>
</tr>

<%} %>

</table>


</div>
</body>
</html>