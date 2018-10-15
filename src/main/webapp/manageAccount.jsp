<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.Bean.AccountBean"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.dao.AdminDao"%>
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
  <div id="managebook">
<% List<AccountBean> list=AdminDao.QueryAccount();
   int sno=1;
%>


<table>
<tr>
<th>SNO</th>
<th>UserName</th>
<th>Gender</th>
<th>Role</th>
<th>Tel</th>
<th>Balance</th>
<th style="width:180px">Money/AddBalance</th>
<th>Cancel</th>
</tr>
<% for(AccountBean ab:list) {%>
<tr>
<td><%=sno++ %></td>
<td><input type="text" value=<%=ab.getUsername() %>></td>
<td><input type="text" value=<%=ab.getGender() %>></td>
<td><input type="text" value=<%=ab.getRole() %>></td>
<td><input type="text" value=<%=ab.getTel() %>></td>
<td><input type="text" value=<%=ab.getBalance() %>  style="width:60px"></td>
<td style="width:180px">
<form action=<%=UrlConstant.Admin_SERVLET %> method="post">
<input type="text" name="increasedmoney" style="width:60px">
<input type="hidden" name="accountid" value=<%=ab.getId() %>>
<input type="submit" name="submit" value="AddBalance" ></form></td>
<td>
<form action=<%=UrlConstant.Admin_SERVLET %> method="post">
<input type="hidden" name="accountid" value=<%=ab.getId() %>>
<input type="submit" name="submit" value="CancelAccount">
</form>
</td>
</tr>
<%}%>
</table>
</div>

</body>
</html>