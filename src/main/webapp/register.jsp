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
<script type="text/javascript">
$(document).ready(function(){
	$('#regform').validate({
		rules:{
			name:"required",
			
			gender:"required",
			
		    tel:"required",
			   
		  
		    loc:"required",
		    email:{
			   required:true,
		       email:true
		   },
			password:{
				required:true,
				minlength:6
			}
	},
		messages:{
			name:"please enter your name",
			gender:"please select gender",
			tel:"please enter your phonenumber",
			loc:"please enter your location",
			email:{
				required:"please enter the email",
				email:"please enter a valid email"
			},
		    password:
		    	{ required:"please enter your password",
			      minlength:"please enter at least 6 character"
		    	}
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
                        <h1><a href="">User Register <span class="red">.</span></a></h1>
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
                    <form  id="regform" action="<%=UrlConstant.User_SERVLET %>" method="post">
                        <h2><span class="red"><strong>Library Register</strong></span></h2>
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" placeholder="enter your name...">
                        <label for="gender">Gender</label>
                       Male<input style="width:20px;" type="radio" id="gender" name="gender" value="male" required="required"/>
                       Female <input style="width:20px;" type="radio" id="genderr" name="gender" value="female" />
                        
                        <label for="role">Role</label>
                       <select  name="role">
                       <option value="student">Student</option>
                       <option value="teacher">Teacher</option>
                       </select>
                        <label for="tel">Tel</label>
                       <input type="text" id="tel" name="tel" placeholder="enter your phonenumber...">
                       <label for="location">Location</label>
                       <input type="text" id="loc" name="loc" placeholder="enter your address...">
                        <label for="email">Email</label>
                        <input type="text" id="email" name="email" placeholder="enter your email...">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="pass" placeholder="enter your password...">
                        <input type="submit" name="submit" value="Register">
                    </form>
                </div>
            </div>
        </div>

       



</body>
</html>