<%@page import="com.niit.constants.UrlConstant"%>
<%@page import="com.niit.constants.MessageConstant"%>
<%@page import="com.niit.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/reset1.min.css" rel="stylesheet" type="text/css" />
</head>

<body><% User user=(User)request.getAttribute(MessageConstant.User); %>


<div class="nav clear">
<ul class="clear">
<li><form action=<%=UrlConstant.User_SERVLET %> method="post">
<input type="hidden" name="userid" value="<%=user.getId() %>">
<input type="submit" name="submit" value="ReturnBook"></form></li>

<li>
<form action=<%=UrlConstant.User_SERVLET %> method="post">
<input type="hidden" name="userid" value="<%=user.getId() %>">
<input type="submit" name="submit" value="LoseBook"></form>
</li>
<li>
<form action=<%=UrlConstant.User_SERVLET %> method="post">
<input type="hidden" name="userid" value="<%=user.getId() %>">
<input type="submit" name="submit" value="CancelReserve"></form>

</li>

</ul>
</div>

<div class="search1">
<div class="imglog">

<h1 style="width:400px;color:red;position:relative;left:-35px;">Hello <%=user.getName()%>  Welcome to the User Interface</h1>


</div>
<div>
<form action="<%=UrlConstant.User_SERVLET %>" method="post">
<input type="text" class="txtingput" name="bookname" />

<input type="hidden" name="userid" value="<%=user.getId()%>">
<input type="submit" class="txtbutton" name="submit" value="searchborrow">
</form>
</div>
</div >
<div class="imglist1">
<ul class="clear">
<li><div><a href=""><img src="img/1.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/2.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/3.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/4.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/5.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/6.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/7.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/8.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/9.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>

<li><div><a href=""><img src="img/10.jpg" /></a>
<div><form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Detials"></form>
<form  style="display:inline"><input type="hidden" name="bookid" value="">
<input style="width:78px;" type="submit" name="submit" value="Borrow">
</form></div></div></li>
</ul>
</div>



</body>
</html>