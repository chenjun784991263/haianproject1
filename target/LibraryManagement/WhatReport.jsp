<%@page import="java.util.List"%>
<%@page import="com.niit.dao.AdminDao"%>
<%@page import="com.niit.dao.UserDAO"%>
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
			<h3>Manage Reserve-Request Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>

<div id="whatreport">
<% List<User> userlist=AdminDao.QueryAllUser();%>

<form action="<%=UrlConstant.Report %>" method="post">
<table>
<tr>
<th>TotalBooks</th>
<th>BorrowedBooks</th>
<th>LostBooks</th>
<th>LateReturnBooks</th>
<th>ReservedBooks</th>
<th>FinedBooks</th>
</tr>
<tr>
<td>
<input type="submit" name="submit" value="totalbooks">

</td>



<td>
<input type="submit" name="submit" value="borrowedbooks">
</td>

<td>
<input type="submit" name="submit" value="lostbooks">
</td>

<td>
<input type="submit" name="submit" value="latereturnbooks">
</td>

<td>
<input type="submit" name="submit" value="reservebooks">
</td>

<td>
<input type="submit" name="submit" value="finedbooks">
</td>

</tr>
</table>
</form>
</div>




</body>
</html>