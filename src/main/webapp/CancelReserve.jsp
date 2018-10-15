<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.Bean.ReserveRecordBean"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.constants.MessageConstant"%>
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
			<h3>CanCel Reserve Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
  <div id="cancelreserve">
  <% List<ReserveRecordBean>list=( List<ReserveRecordBean>)request.getAttribute(MessageConstant.ReserveRecord);
    int sno=1;
  %>
  <table>
<tr>
<th>Sno</th>
<th>BookName</th>
<th>Author</th>
<th>ReleasingTime</th>
<th>price</th>
<th>CancelReserve</th>
</tr>
<%for(ReserveRecordBean rrb:list){%>
<tr>
<td><%=sno++ %></td>
<td><input type="text"  value="<%=rrb.getBookname() %>"></td>
<td><input type="text"  value="<%=rrb.getAuthor() %>"></td>
<td><input type="text"  value="<%=rrb.getReleasingtime() %>"></td>
<td><input type="text"  value="<%=rrb.getPrice()%>"></td>

<td><form action=<%=UrlConstant.User_SERVLET%> method="post" >
<input type="hidden" name="reserverecordid" value="<%=rrb.getId() %>">
<input type="hidden" name="bookid" value="<%=rrb.getBookid() %>">

<input type="hidden" name="userid" value="<%=request.getAttribute(MessageConstant.UserID) %>">

<input type="submit" name="submit" value="cancelreserve"></form></td>  
  
  </tr>
<% }%>
  </table>
  
  </div>
</body>
</html>