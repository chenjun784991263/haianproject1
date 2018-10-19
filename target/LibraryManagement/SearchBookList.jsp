<%@page import="java.util.List"%>
<%@page import="com.niit.model.Book"%>
<%@page import="com.niit.constants.MessageConstant"%>
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
			<h3>Search for Borrow/Reserve Book Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
   
   <div id="searchbook">
<% 
  List<Book>list=(List<Book>)request.getAttribute(MessageConstant.BookList);
  int sno=1;%>


<table>
<tr>
<th>Sno</th>
<th>Name</th>
<th>Author</th>
<th>ReleasingTime</th>
<th>price</th>
<th>ContentType</th>
<th>Reserve/Borrow</th>
</tr>
<%for(Book book:list){ if(book!=null) {%>
<tr>
<td><%=sno++ %></td>
<td><%=book.getName() %></td>
<td><%=book.getAuthor() %></td>
<td><%=book.getReleasingtime() %></td>
<td><%=book.getPrice() %></td>
<td><%=book.getContenttype() %></td>
<td><form action=<%=UrlConstant.User_SERVLET%> method="post" >
<input type="hidden" name="userid" value=<%=request.getAttribute(MessageConstant.UserID)%>>
<input type="hidden" name="bookid" value=<%=book.getId()%>>
<input type="submit" name="submit" value="ReserveBook"></form></td>

<td><form action=<%=UrlConstant.User_SERVLET%> method="post" >
<input type="hidden" name="userid" value=<%=request.getAttribute(MessageConstant.UserID) %>>
<input type="hidden" name="bookid" value=<%=book.getId()%>>
<span>BorrowLength<input type="text" name="borrowlength"></span>
<input type="submit" name="submit" value="borrowbook"></form></td>


<tr>

<%}} %>

</table>
   
   </div>




</body>
</html>