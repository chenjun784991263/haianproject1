<%@page import="com.niit.constants.MessageConstant"%>
<%@page import="com.niit.model.Book"%>
<%@page import="com.niit.model.Type"%>
<%@page import="com.niit.dao.AdminDao"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.model.Publisher"%>
<%@page import="com.niit.constants.UrlConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>Edit Book</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
 <!-- Javascript -->
        <script src="assets/js/jquery-3.2.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
      
        <script src="assets/js/jquery.validate.min.js"></script>

    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">Edit Book <span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                        <a class="home" href="" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="blog" href="" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyrights">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>

        <div class="register-container container">
            <div class="row">
            <% 
  Book book=(Book)request.getAttribute(MessageConstant.Book);
  List<Publisher>pub=AdminDao.QueryAllPublisher();
  List<Type>type=AdminDao.QueryAllBookType();

  %>
              
                <div class="register span6">
                    <form  id="regform" action="<%=UrlConstant.Admin_SERVLET %>" method="post">
                        <h2><span class="red"><strong>Add Book</strong></span></h2>
                        <label for="name">Name</label>
                       <input type="text" name="bookname" value="<%=book.getName() %>">
                        <label for="author">Author</label>
                        <input type="text" name="author"  value="<%=book.getAuthor() %>">
                        <label for="releasingtime">ReleasingTime</label>
                       <input type="text" name="releasingtime" value="<%=book.getReleasingtime() %>">
                        <label for="tel">Publisher</label>
                     <select name="publisher">
  <%for(Publisher p:pub){ %>
  
  <option value=<%=p.getId()%> <%if(book.getPublisherid()==p.getId()){%>selected <%}%>><%=p.getName() %></option>
  <% }%>
</select>
                       <label for="price">Price</label>
                      <input type="text" name="price" value="<%=book.getPrice() %>">
                        <label for="contenttype">ContentType</label>
                      <input type="text" name="contenttype" value="<%=book.getContenttype() %>">
                        <label for="type">Type</label>
                       
                     <select name="type">
  <%for(Type t:type){ %>
  
  <option value=<%=t.getId()%> <%if(book.getTypeid()==t.getId()){%>selected<%}%>><%=t.getName() %>&nbsp;<%=t.getReleasingtype() %></option>
  <% }%>
</select>
                      <input type="hidden" name="id" value="<%=book.getId() %>">
                      <input type="submit" name="submit" value="editbook">
                    </form>
                </div>
            </div>
        </div>

       



</body>
</html>