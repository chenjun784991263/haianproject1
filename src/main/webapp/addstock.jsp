<%@page import="java.util.List"%>
<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.Bean.StockBean"%>
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
			<h3>Add Stock Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
  <div id="addstock">
<% 
  List<StockBean> list=(List<StockBean>)request.getAttribute(MessageConstant.StockList);

  int sno=1;%>

<table>
<tr>
<th>Sno</th>
<th>Name</th>
<th>Author</th>
<th>ReleasingTime</th>
<th>price</th>
<th>ContentType</th>
<th>NumToAdd/AddStock</th>
</tr>
<%for(StockBean stock:list){%>
<tr>
<td><%=sno++ %></td>
<td><input type="text"  value="<%=stock.getName() %>"></td>
<td><input type="text"  value="<%=stock.getAuthor() %>"></td>
<td><input type="text"  value="<%=stock.getReleasingtime() %>"></td>
<td><input type="text"  value="<%=stock.getPrice()%>"></td>
<td><input type="text"  value="<%=stock.getContenttype() %>"></td>
<td><form action="<%=UrlConstant.Admin_SERVLET %>" method="post">
<input type="hidden" name="stockid" value="<%=stock.getId() %>" >
<input type="text" name="numtoadd" style="width:40px;">
<input type="submit" name="submit" value="addstock">
</form>
</td>
</tr>
<% }%>
</table>
</div>

</body>
</html>