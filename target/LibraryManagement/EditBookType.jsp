<%@page import="com.niit.constants.MessageConstant"%>
<%@page import="com.niit.model.Type"%>
<%@page import="com.niit.constants.UrlConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>Edit BookType</title>
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
                        <h1><a href="">Edit BookType <span class="red">.</span></a></h1>
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
          <% Type t=(Type)request.getAttribute(MessageConstant.Type);%>
                <div class="register span6">
                    <form  id="regform" action="<%=UrlConstant.Admin_SERVLET %>" method="post">
                        <h2><span class="red"><strong>Edit BookType</strong></span></h2>
                        <label for="name">TypeName</label>
                        <input type="text" name="typename" value="<%=t.getName() %>">
                        <label for="releasingtype">ReleasingType</label>
                        <input type="text" name="releasingtype" value="<%=t.getReleasingtype() %>">
                        <label for="createdate">CreateDate</label>
                        <input type="text" name="time" value="<%=t.getTime() %>">
                      <input type="hidden" name="id" value="<%=t.getId() %>">
                      <input type="submit" name="submit" value="editbooktype">
                    </form>
                </div>
            </div>
        </div>

       

</body>
</html>