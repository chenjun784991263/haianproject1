<%@page import="com.niit.Bean.StockBean"%>
<%@page import="com.niit.Bean.BorrowRecordBean"%>
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
			<h3>Manage Reserve-Request Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
<div id="report">
<% List<StockBean> stocklist=(List<StockBean>)request.getAttribute(MessageConstant.Stock) ;%>

<table>

<tr>
<th>BookName</th>
<th>Author</th>
<th>ReleasingTime</th>
<th>Price</th>
<th>ContentType</th>
<th>Quantity</th>
</tr>
<%for(StockBean sb:stocklist) {%>
<tr>
<td><%=sb.getName()%></td>
<td><%=sb.getAuthor() %></td>
<td><%=sb.getReleasingtime() %></td>
<td><%=sb.getPrice() %></td>
<td><%=sb.getContenttype() %></td>
<td><%=sb.getQuantity() %></td>
</tr>
<% }%>
</table>


</div>



</body>
</html>