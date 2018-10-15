<%@page import="com.niit.model.Type"%>
<%@page import="com.niit.model.Publisher"%>
<%@page import="com.niit.service.AdminService"%>
<%@page import="com.niit.dao.AdminDao"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.Bean.BookBean"%>
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
  <div id="managebook">
<% 
  List<BookBean>list=(List<BookBean>)AdminService.QueryBook();
  List<Publisher>pub=AdminDao.QueryAllPublisher();
  List<Type>type=AdminDao.QueryAllBookType();

  int sno=1;%>

<table>
<tr>
<th>Sno</th>
<th>Name</th>
<th>Author</th>
<th>ReleasingTime</th>
<th>Pubisher</th>
<th>price</th>
<th>ContentType</th>
<th>Type</th>
<th>State</th>
<th>Add</th>
<th>Edit</th>
<th>Delete</th>
<th>ChangeState</th>
</tr>
<%for(BookBean book:list){ if(book!=null) {%>
<tr>
<td><%=sno++ %></td>
<td><input type="text"  value="<%=book.getName() %>"></td>
<td><input type="text"  value="<%=book.getAuthor() %>"></td>
<td><input type="text"  value="<%=book.getReleasingtime() %>"></td>
<td><input type="text"  value="<%=book.getPublishername() %>"></td>
<td><input type="text"  value="<%=book.getPrice()%>"></td>
<td><input type="text"  value="<%=book.getContenttype() %>"></td>
<td><input type="text"  value="<%=book.getType()%>"></td>


<td><%if(book.getFlag()==1){ %>Active<%}else{ %>Block<% } %></td>
<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" ><input type="submit" name="submit" value="AddBook"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=book.getId() %>">
<input type="submit" name="submit" value="EditBook"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=book.getId() %>">
<input type="submit" name="submit" value="DeleteBook"></form></td>

<td><form action=<%=UrlConstant.Admin_SERVLET%> method="post" >
<input type="hidden" name="id" value="<%=book.getId() %>">
<input type="submit" name="submit" value="ChangeBookState"></form></td>


<tr>

<%}} %>

</table>

   </div>


</body>
</html>