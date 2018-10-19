<%@page import="com.niit.Bean.FineRecordBean"%>
<%@page import="com.niit.Bean.ReserveRecordBean"%>
<%@page import="com.niit.Bean.OverdueRecordBean"%>
<%@page import="com.niit.Bean.LoseRecordBean"%>
<%@page import="com.niit.dao.UserDAO"%>
<%@page import="com.niit.dao.AdminDao"%>
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
			<h3>Library Situation Display Interface</h3>
		</div>
		<div class="fr top-link">
			<a href="admin_list.html" target="mainCont" title="DeathGhost"><i
				class="adminIcon"></i><span>管理员：Adam</span></a> 
		</div>
	</div>
<hr>
<%if(request.getAttribute(MessageConstant.Show)=="totalbooks") {%>
<div id="showdetails">
<% List<StockBean> stocklist=AdminDao.queryStock();%>
<h1>The TotalBooks' Details</h1>
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

<% }%>

<%if(request.getAttribute(MessageConstant.Show)=="borrowedbooks"){%>
<div id="showdetails">
<% List<BorrowRecordBean> borrowedlist=UserDAO.QueryBorrowRecord();
   int sno=1;
%>
<h1>The BorrowedBooks' Details</h1>
<table>
<tr>
<th>Sno</th>
<th>UserName</th>
<th>BookName</th>
<th>Author</th>
<th>price</th>
<th>ReleasingTime</th>
<th>BorrowDate</th>
<th>ShouldReturnDate</th>

</tr>
<%for(BorrowRecordBean brb:borrowedlist){%>
<tr>
<td><%=sno++ %></td>
<td><%=brb.getUsername() %></td>
<td><%=brb.getBookname()%></td>
<td><%=brb.getAuthor() %></td>
<td><%=brb.getPrice() %></td>
<td><%=brb.getReleasingtime()%></td>
<td><%=brb.getBorrowdate()%></td>
<td><%=brb.getShouldreturndate() %></td>
</tr>
<% }%>
</table>
</div>
<% }%>

<%if(request.getAttribute(MessageConstant.Show)=="lostbooks"){%>
<div id="showdetails">
<% List<LoseRecordBean> lostlist=UserDAO.QueryLoseRecord();
   int sno=1;
%>
<h1>The LostBooks' Details</h1>
<table>
<tr>
<th>Sno</th>
<th>UserName</th>
<th>BookName</th>
<th>Author</th>
<th>price</th>
<th>ReleasingTime</th>
<th>LoseTime</th>


</tr>
<%for(LoseRecordBean brb:lostlist){%>
<tr>
<td><%=sno++ %></td>
<td><%=brb.getUsername() %></td>
<td><%=brb.getBookname()%></td>
<td><%=brb.getAuthor() %></td>
<td><%=brb.getPrice() %></td>
<td><%=brb.getReleasingtime()%></td>
<td><%=brb.getLosetime()%></td>

</tr>
<% }%>
</table>
</div>
<% }%>

<%if(request.getAttribute(MessageConstant.Show)=="latereturnbooks"){%>
<div id="showdetails">
<% List<OverdueRecordBean> overduelist=UserDAO.QueryOverdueRecord();
   int sno=1;
%>
<h1>The LateReturnBooks' Details</h1>
<table>
<tr>
<th>Sno</th>
<th>UserName</th>
<th>BookName</th>
<th>Author</th>
<th>price</th>
<th>ReleasingTime</th>
<th>ShouldReturnDate</th>
<th>OverdueDays</th>

</tr>
<%for(OverdueRecordBean brb:overduelist){%>
<tr>
<td><%=sno++ %></td>
<td><%=brb.getUsername() %></td>
<td><%=brb.getBookname()%></td>
<td><%=brb.getAuthor() %></td>
<td><%=brb.getPrice() %></td>
<td><%=brb.getReleasingtime()%></td>
<td><%=brb.getShoulddreturndate()%></td>
<td><%=brb.getOverduedays() %></td>
</tr>
<% }%>
</table>
</div>
<% }%>

<%if(request.getAttribute(MessageConstant.Show)=="reservedbooks"){%>
<div id="showdetails">
<% List<ReserveRecordBean> reservedlist=UserDAO.QueryReserveRecord();
   int sno=1;
%>
<h1>The ReservedBooks' Details</h1>
<table>
<tr>
<th>Sno</th>
<th>UserName</th>
<th>BookName</th>
<th>Author</th>
<th>price</th>
<th>ReleasingTime</th>

</tr>
<%for(ReserveRecordBean brb:reservedlist){%>
<tr>
<td><%=sno++ %></td>
<td><%=brb.getUsername() %></td>
<td><%=brb.getBookname()%></td>
<td><%=brb.getAuthor() %></td>
<td><%=brb.getPrice() %></td>
<td><%=brb.getReleasingtime()%></td>

</tr>
<% }%>
</table>
</div>
<% }%>

<%if(request.getAttribute(MessageConstant.Show)=="finedbooks"){%>
<div id="showdetails">
<% List<FineRecordBean> finedlist=UserDAO.QueryFineRecord();
   int sno=1;
%>
<h1>The FinedBooks' Details</h1>
<table>
<tr>
<th>Sno</th>
<th>UserName</th>
<th>BookName</th>
<th>Author</th>
<th>price</th>
<th>ReleasingTime</th>
<th>OverdueLength</th>
<th>OverdueFine</th>
</tr>
<%for(FineRecordBean brb:finedlist){%>
<tr>
<td><%=sno++ %></td>
<td><%=brb.getUsername() %></td>
<td><%=brb.getBookname()%></td>
<td><%=brb.getAuthor() %></td>
<td><%=brb.getPrice() %></td>
<td><%=brb.getReleasingtime()%></td>
<td><%=brb.getOverduelength() %></td>
<td><%=brb.getOverduefine() %></td>

</tr>
<% }%>
</table>
</div>
<% }%>






</body>
</html>