<%@page import="com.niit.constants.MessageConstant"%>
<%@page import="com.niit.model.User"%>
<%@page import="com.niit.constants.UrlConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>Register</title>
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
                        <h1><a href="">User Edit interface<span class="red">.</span></a></h1>
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
              
                <div class="register span6">
                <% User user=(User)request.getAttribute(MessageConstant.User);%>
                    <form  id="regform" action="<%=UrlConstant.Admin_SERVLET %>" method="post">
                        <h2><span class="red"><strong>Library Register</strong></span></h2>
                        <input type="hidden" name="id" value="<%=user.getId() %>">
                        <label for="name">Name</label>
                        <input type="text" name="name" value="<%=user.getName()%>">
                         
                        <label for="gender">Gender</label>
                      <input type="radio" name="gender" value="male" checked="<%if(user.getGender().equals("male")){ %>checked<%} %>">Male
                      <input type="radio" name="gender" value="female" checked="<%if(user.getGender().equals("female")){ %>checked<%} %>">Female
                        
                        <label for="role">Role</label>
                       <select  name="role">
                       <option value="student" selected="<%if(user.getRole().equalsIgnoreCase("student")){ %>selected<%} %>">Student</option>
                       <option value="teacher" selected="<%if(user.getRole().equalsIgnoreCase("teacher")){ %>selected<%} %>">Teacher</option>
                       </select>
                        <label for="tel">Tel</label>
                      <input type="text" name="tel" value="<%=user.getTel() %>">
                       <label for="location">Location</label>
                       <input type="text" name="loc" value="<%=user.getLoc() %>">
                        <label for="email">Email</label>
                       <input type="text" name="email" value="<%=user.getEmail()%>">
                        <label for="password">Password</label>
                       <input type="password"  name="pass" value="<%=user.getPassword() %>">
                        <input type="submit" name="submit" value="Edit_User">
                    </form>
                </div>
            </div>
        </div>

       



</body>
</html>