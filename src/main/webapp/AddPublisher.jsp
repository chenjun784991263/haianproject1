<%@page import="com.niit.constants.UrlConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>Add Publisher</title>
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
			
			loc:"required",
			
		    tel:"required",
			   
		  
		   
	},
		messages:{
			name:"please enter your publishername",
			loc:"please enter your publisherlocation",
			tel:"please enter your publisherphonenumber",
		
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
                        <h1><a href="">Add Publisher <span class="red">.</span></a></h1>
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
                    <form  id="regform" action="<%=UrlConstant.Admin_SERVLET %>" method="post">
                        <h2><span class="red"><strong>Add Publisher</strong></span></h2>
                        <label for="name">Name</label>
                        <input type="text" id="name" name="publishername" placeholder="enter your publishername...">
                        <label for="location">Location</label>
                        <input type="text" id="loc" name="loc" placeholder="enter your publisherlocation...">
                        <label for="tel">Tel</label>
                        <input type="text" id="tel" name="tel" placeholder="enter your publisherphonenumber...">
                      
                    
                    
                      <input type="submit" name="submit" value="addpublisher">
                    </form>
                </div>
            </div>
        </div>

       


</body>
</html>