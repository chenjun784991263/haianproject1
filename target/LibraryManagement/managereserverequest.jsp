<%@page import="com.niit.Bean.ReserveRecordBean"%>
<%@page import="com.niit.Bean.BorrowRecordBean"%>
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
			<h3>Manage Reserve-Request Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
   <div id="reservereq">
   <% int sno=1;
      List<ReserveRecordBean>list=AdminDao.QueryReserveRecord(); 
   %>
   
   <table>
   <tr>
   <th>SNO</th>
   <th>UserName</th>
   <th>BookName</th>
   <th>Approve</th>
   <th>Reject</th>
   </tr>
   <% for(ReserveRecordBean brb:list) {%>
   <tr>
   <td><%=sno++%></td>
   <td><input type="text" value="<%=brb.getUsername() %>"></td>
   <td><input type="text" value="<%=brb.getBookname() %>"></td>
   <td><form action="<%=UrlConstant.Admin_SERVLET %>" method="post">
     <input type="hidden" name="bookname" value="<%=brb.getBookname() %>">
     <input type="hidden" name="reserverecordid" value="<%=brb.getId() %>">
     <input type="hidden" name="userid"  value="<%=brb.getUserid()%>">
     <input type="submit" name="submit" value="approvereserve">
   </form>
   </td>
   <td>
   <form action="<%=UrlConstant.Admin_SERVLET %>" method="post">
     <input type="hidden" name="reserverecordid" value="<%=brb.getId() %>">
     <input type="hidden" name="userid"  value="<%=brb.getUserid()%>">
     <input type="hidden" name="bookname" value="<%=brb.getBookname() %>">
     <input type="submit" name="submit" value="rejectreserve">
   </form>
   
   </td>
   
   </tr>
   <% }%>
   </table>
   </div>
</body>
</html>
