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
   <title>Add Book</title>
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
<script type="text/javascript">
$(document).ready(function(){
	$('#regform').validate({
		rules:{
			name:"required",
			
			author:"required",
			
		    releasingtime:"required",
			   
		  
		    price:"required",
		    
		    contenttype:"required",
		    
		    quantity:"required",
	},
		messages:{
			name:"please enter your bookname",
			author:"please enter your bookauthor",
			releasingtime:"please enter your bookreleasingtime",
			price:"please enter your bookprice",
			contenttype:"please enter your bookcontenttype",
			quantity:"please enter the book quantity"
		}
		
	});
});
</script>
    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">Add Book <span class="red">.</span></a></h1>
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
              <% List<Publisher>pub=AdminDao.QueryAllPublisher();
              List<Type>type=AdminDao.QueryAllBookType();

               %>
              
                <div class="register span6">
                    <form  id="regform" action="<%=UrlConstant.Admin_SERVLET %>" method="post">
                        <h2><span class="red"><strong>Add Book</strong></span></h2>
                        <label for="name">Name</label>
                        <input type="text" id="name" name="bookname" placeholder="enter your bookname...">
                        <label for="author">Author</label>
                        <input type="text" id="author" name="author" placeholder="enter your bookauthor...">
                        <label for="releasingtime">ReleasingTime</label>
                        <input type="text" id="releasingtime" name="releasingtime" placeholder="enter your bookreleasingtime...">
                        <label for="tel">Publisher</label>
                      <select name="publisher">
                      <%for(Publisher p:pub){ %>
  
                      <option value=<%=p.getId() %>><%=p.getName() %></option>
                      <% }%>
                      </select>
                       <label for="price">Price</label>
                       <input type="text" id="price" name="price" placeholder="enter your bookprice...">
                        <label for="contenttype">ContentType</label>
                        <input type="text" id="contenttype" name="contenttype" placeholder="enter your bookcontenttype...">
                        <label for="type">Type</label>
                        <select name="type">
                       <%for(Type t:type){ %>
  
                       <option value=<%=t.getId() %>><%=t.getName() %>&nbsp;<%=t.getReleasingtype() %></option>
                       <% }%>
                      </select>
                      <label>Quantity</label>
                      <input type="text" id="quantity" name="quantity">
                      <input type="submit" name="submit" value="addbook">
                    </form>
                </div>
            </div>
        </div>

       



</body>
</html>