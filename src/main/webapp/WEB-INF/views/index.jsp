<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from templates.scriptsbundle.com/knowledge/demo/index.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 07:33:11 GMT -->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="author" content="ScriptsBundle">
	<title>Online Mock Test</title>
	<!-- =-=-=-=-=-=-= Favicons Icon =-=-=-=-=-=-= -->
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico"/>" type="image/x-icon" />
	<!-- =-=-=-=-=-=-= Mobile Specific =-=-=-=-=-=-= -->
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<!-- =-=-=-=-=-=-= Bootstrap CSS Style =-=-=-=-=-=-= -->
	<!-- <link rel="stylesheet" href="css/bootstrap.css">  -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
	<!-- =-=-=-=-=-=-= Template CSS Style =-=-=-=-=-=-= -->
	<!-- <link rel="stylesheet" href="css/style.css">  --> 
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
	<!-- =-=-=-=-=-=-= Font Awesome =-=-=-=-=-=-= -->
	<!-- <link rel="stylesheet" href="css/font-awesome.css">  -->
	<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css"/>">
	<!-- =-=-=-=-=-=-= Et Line Fonts =-=-=-=-=-=-= -->
	<!-- <link rel="stylesheet" href="css/et-line-fonts.css">  -->
	<link rel="stylesheet" href="<c:url value="/resources/css/et-line-fonts.css"/>">
	<!-- =-=-=-=-=-=-= Google Fonts =-=-=-=-=-=-= -->
	<link href="../../../fonts.googleapis.com/cssd7e8.css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic|Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css">
	<!-- =-=-=-=-=-=-= Owl carousel =-=-=-=-=-=-= -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/owl.carousel.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/owl.style.css"/>">
	<!-- =-=-=-=-=-=-= Highliter Css =-=-=-=-=-=-= -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles/shCoreDefault.css" />"/>
    <!-- =-=-=-=-=-=-= Css Animation =-=-=-=-=-=-= -->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/animate.min.css" />"/>
    <!-- =-=-=-=-=-=-= Hover Dropdown =-=-=-=-=-=-= -->
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/bootstrap-dropdownhover.min.css" />"/>
	
	<!-- JavaScripts -->
	<script src="<c:url value="/resources/js/modernizr.js"/>"></script>
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	
	<!--[if lt IE 9]-->
    <script src="http://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<!--  [endif]-->
	
	        <script>
			function myFunction() 
			{
  				var x = document.getElementById("myInput");
  				if (x.type === "password") 
  				{
    				x.type = "text";
  				} 
  				else 
  				{
    				x.type = "password";
  				}
			}
			function myFunction1() 
			{
  				var x = document.getElementById("myInput1");
  				if (x.type === "password") 
  				{
    				x.type = "text";
  				} 
  				else 
  				{
    				x.type = "password";
  				}
			}
			function myFunction2() 
			{
  				var x = document.getElementById("myInput2");
  				if (x.type === "password") 
  				{
    				x.type = "text";
  				} 
  				else 
  				{
    				x.type = "password";
  				}
			}
		</script>
        <script type="text/javascript">
            var request;
            function forgotexpert()
            {
            var v=document.expertlogin.id.value;
            var url="forgotexpert?expertid="+v;

            if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
            }

            try
            {
            request.onreadystatechange=getInfoExpert;
            request.open("GET",url,true);
            request.send();
            }
            catch(e)
            {
            alert("Unable to connect to server");
            }

            }

            function getInfoExpert(){
            if(request.readyState==4){
            var val=request.responseText;
                if(val.trim() == "success")
                {
                    swal ( 'Message From Server' ,  'New password has been sent on your email-id' ,'warning' );
                }
                else
                {
                    swal ( 'Message From Server' ,  'System Error Occurred' ,'warning' );
                }
            }
            }
            
            
            function forgotcustomer()
            {
            var v=document.customerlogin.id.value;
            var url="forgotcustomer?custid="+v;

            if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
            }

            try
            {
            request.onreadystatechange=getInfoCustomer;
            request.open("GET",url,true);
            request.send();
            }
            catch(e)
            {
            alert("Unable to connect to server");
            }

            }

            function getInfoCustomer(){
            if(request.readyState==4){
            var val=request.responseText;
                if(val.trim() == "success")
                {
                    swal ( 'Message From Server' ,  'New password has been sent on your email-id' ,'warning' );
                }
                else
                {
                    swal ( 'Message From Server' ,  'System Error Occurred' ,'warning' );
                }
            }
            }
            
            function forgotadmin()
            {
            var v=document.adminlogin.id.value;
            var url="forgotadmin?adminid="+v;

            if(window.XMLHttpRequest){
            request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
            request=new ActiveXObject("Microsoft.XMLHTTP");
            }

            try
            {
            request.onreadystatechange=getInfoAdmin;
            request.open("GET",url,true);
            request.send();
            }
            catch(e)
            {
            alert("Unable to connect to server");
            }

            }

            function getInfoAdmin(){
            if(request.readyState==4){
            var val=request.responseText;
                if(val.trim() == "success")
                {
                    swal ( 'Message From Server' ,  'New password has been sent on your email-id' ,'warning' );
                }
                else
                {
                    swal ( 'Message From Server' ,  'System Error Occurred' ,'warning' );
                }
            }
            }
		</script>
	
</head>

<body>
	<!-- =-=-=-=-=-=-= PRELOADER =-=-=-=-=-=-= -->
	<div class="preloader"><span class="preloader-gif"></span></div>
	<!-- =-=-=-=-=-=-= HEADER =-=-=-=-=-=-= -->
	<div class="top-bar">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6 col-xs-4">
				<ul class="top-nav nav-left">
				<!-- 	<li><a href="index.jsp">Home</a>
					</li>   -->
					<!--li class="hidden-xs"><a href="blog.jsp">Blog</a>
					</li//-->
				</ul>
			</div>
<!--  			<div class="col-lg-8 col-md-8 col-sm-6 col-xs-8">
				<ul class="top-nav nav-right">
					<li><a href="login_form.jsp"><i class="fa fa-lock" aria-hidden="true"></i>Login</a>
					</li>
				</ul>
			</div>  -->
		</div>
	</div>
	</div>
	<!-- =-=-=-=-=-=-= HEADER Navigation =-=-=-=-=-=-= -->
	<div class="navbar navbar-default">
		<div class="container">
			<!-- header -->
			<div class="navbar-header">
				<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- logo -->
				<a href="index" class="navbar-brand">
					<img class="img-responsive" alt="" src="<c:url value="/resources/images/logo.png"/>" height="80px" width="80px">
				</a>
				<!-- header end -->
			</div>
			<!-- navigation menu -->
			<div class="navbar-collapse collapse">
				<!-- right bar -->
				<ul class="nav navbar-nav navbar-right">
					<!--li class="hidden-sm"><a href="how-work.jsp">How  It Works</a// </li>  -->
					<!--li><a href="listing.jsp">Browse Questions</a></li-->
					<!--li class="dropdown"><a class="dropdown-toggle " data-hover="dropdown" data-toggle="dropdown" data-animations="fadeInUp">Pages <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="404.jsp">Error Page</a></li>
						</ul>
					</li-->
					<li>
						<div class="btn-nav"><a href="#" class="btn btn-primary btn-small navbar-btn">Welcome to Online Mock Test</a></div>
					</li>
				</ul>
			</div>
			<!-- navigation menu end -->
			<!--/.navbar-collapse -->
		</div>
	</div>
	<!-- HEADER Navigation End -->
	<!-- =-=-=-=-=-=-= HOME =-=-=-=-=-=-= -->
	<div class="full-section search-section">
		<div class="search-area container">
<!--  				<section class="section-padding-80 white" id="login">  -->
					
      				<div class="container">
        				<div class="row">
          					<div class="col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
					            <div class="box-panel">
					            	<h2 class="search-title" align="center">Login Here!!!</h2><br>
					            	<form action="login" autocomplete="off" method="post" name="adminlogin">
					                <div class="form-group">
                  							<label>Email</label>
                  							<input type="text" placeholder="Enter your email" name="username" class="form-control" required>
    								</div>
                					<div class="form-group">
                  						<label>Password</label>
                  						<input type="password" placeholder="Enter your password" name="password" class="form-control" required id="myInput"><br>
                  						<input type="checkbox" onclick="myFunction()"> Show Password
                					</div>
                 					<div>
                     					<button class="btn btn-primary btn-lg btn-block">Log In</button>
                  					</div>
           							<div class="form-group">
                  						<div class="row">
                    						<div class="col-xs-6">
                      							<div class="checkbox flat-checkbox">
            	            						<!--label>
                	          						<input type="checkbox">
                    	      						<span class="fa fa-check"></span> Remember me?
                        							</label-->
        	              						</div>
    	                					</div>
	                    					<div class="col-xs-6 text-right">
                        						<!--p class="help-block"><button class="btn btn-link" data-toggle="modal" onclick="forgotadmin()" id="foradmin">Forgot password?</button></p--->
                      							<p class="help-block"><a data-toggle="modal" onclick="forgotadmin()" id="foradmin">Forgot password?</a></p>
                    						</div>
                  						</div>
                					</div>
              					</form>
            				</div>
          				</div>
            			<div class="clearfix"></div>
        			</div>
      			</div>
      			<!-- end container -->
   <!-- 			</section> -->
							
			
			
<!--              	<form autocomplete="off" method="post" class="search-form clearfix" id="search-form" action="Check.jsp">
					<input type="text" title="Username" placeholder="Enter Username" class="search-term " autocomplete="off">
				
				<input type="text" title="* Please enter a search term!" placeholder="Type your search terms here" class="search-term " autocomplete="off">
				<input type="submit" value="Search" class="search-btn">
				</form>
				-->
		</div>
	</div>
<!--          
        <br><br>   -->
	<!-- =-=-=-=-=-=-= HOME END =-=-=-=-=-=-= -->
	<!-- =-=-=-=-=-=-= Main Area =-=-=-=-=-=-= -->
<!-- 	<div class="main-content-area">  -->
		<!-- =-=-=-=-=-=-= Latest Questions  =-=-=-=-=-=-= -->
<!--         </div>
	 -->	
		<!-- =-=-=-=-=-=-= Blog & News end =-=-=-=-=-=-= -->
		<!-- =-=-=-=-=-=-= Testimonials =-=-=-=-=-=-= -->
<!-- 		<section data-stellar-background-ratio="0.1" class="testimonial-bg parallex">
			<div class="container">
 -->				<!-- Row -->
	<!-- 			<div class="row">  -->
					<!-- Blog Grid -->
<!-- 					<div class="col-md-8 ">
						<div id="owl-slider" class="happy-client">
							<div class="item"> <i class="fa fa-quote-left"> </i>
								<p>Expert Messaging System is a question and answer site for professional and enthusiasts. It features questions and answers on a wide variety of topics ranging from music , sports , business , art , cookery , health etc. The website serves as a platform for users to ask questions and assigned experts for the topics to answer those questions.</p>
								<div class="client-info-wrap clearfix">
									<div class="client-img">
	 -->									<!--img class="img-circle" src="../../../theemon.com/d/designagency/LivePreview/assets/images/client-img-two.jpg" alt="" /-->
		<!-- 							</div>
									<div class="client-info"> <strong>Expert Messaging</strong>
									</div>
								</div>
							</div>
							<div class="item"> <i class="fa fa-quote-left"> </i>
								<p>Expert Messaging System is a question and answer site for professional and enthusiasts. It features questions and answers on a wide variety of topics ranging from music , sports , business , art , cookery , health etc. The website serves as a platform for users to ask questions and assigned experts for the topics to answer those questions.</p>
								<div class="client-info-wrap clearfix">
									<div class="client-img">
			 -->							<!--img class="img-circle" src="../../../theemon.com/d/designagency/LivePreview/assets/images/client-img-two.jpg" alt="" /-->
				<!-- 					</div>
									<div class="client-info"> <strong>Expert Messaging</strong> 
									</div>
								</div>
							</div>
						</div>
					</div>
			 -->		<!-- Blog Grid -->
					<!-- Blog Grid -->
				<!-- 	<div class="col-md-4 no-padding">
						<div class="success-stories">
							<div class="main-heading text-center">
								<h2>Admin Detail</h2>
								<hr class="main">
                                                                <p><Strong>Email-</strong>ektadiwakar536@gmail.com<br><Strong>Contact-</Strong>8120023700</p>
							</div>
						</div>
					</div>
	 -->				<!-- Blog Grid -->
		<!-- 			<div class="clearfix"></div>
				</div>
 -->				<!-- Row End -->
	<!-- 		</div>
		 -->	<!-- end container -->
<!-- 		</section>   
	 -->	<!-- =-=-=-=-=-=-= Testimonials  =-=-=-=-=-=-= -->
		<!-- =-=-=-=-=-=-= Our Clients =-=-=-=-=-=-= -->
		<!--section class="custom-padding" id="clients">
			<div class="container">
				<!-- Row -->
				<!--div class="row">
					<!-- col-md-2 client-block -->
					<!--div class="col-md-2 col-sm-4 col-xs-6 client-block">
						<!-- client-item client-item-style-2 -->
						<!--div class="client-item client-item-style-2">
							<a title="Client Logo" href="#">
								<img alt="Clients Logo" src="images/clients/client_5.png">
							</a>
						</div>
						<!-- /client-item client-item-style-2 -->
					<!--/div>
					<!-- /col-md-2 client-block -->
					<!-- col-md-2 client-block -->
					<!--div class="col-md-2 col-xs-6 col-sm-4 client-block">
						<!-- client-item client-item-style-2 -->
						<!--div class="client-item client-item-style-2">
							<a title="Client Logo" href="#">
								<img alt="Clients Logo" src="images/clients/client_6.png">
							</a>
						</div>
						<!-- /client-item client-item-style-2 -->
					<!--/div>
					<!-- /col-md-2 client-block -->
					<!-- col-md-2 client-block -->
					<!--div class="col-md-2  col-xs-6 col-sm-4 client-block">
						<!-- client-item client-item-style-2 -->
						<!--div class="client-item client-item-style-2">
							<a title="Client Logo" href="#">
								<img alt="Clients Logo" src="images/clients/client_7.png">
							</a>
						</div>
						<!-- /client-item client-item-style-2 -->
					<!--/div>
					<!-- /col-md-2 client-block -->
					<!-- col-md-2 client-block -->
					<!--div class="col-md-2 col-xs-6 col-sm-4 client-block">
						<!-- client-item client-item-style-2 -->
						<!--div class="client-item client-item-style-2">
							<a title="Client Logo" href="#">
								<img alt="Clients Logo" src="images/clients/client_8.png">
							</a>
						</div>
						<!-- /client-item client-item-style-2 -->
					<!--/div>
					<!-- /col-md-2 client-block -->
					<!-- col-md-2 client-block -->
					<!--div class="col-md-2 col-xs-6 col-sm-4 client-block">
						<!-- client-item client-item-style-2 -->
						<!--div class="client-item client-item-style-2">
							<a title="Client Logo" href="#">
								<img alt="Clients Logo" src="images/clients/client_9.png">
							</a>
						</div>
						<!-- /client-item client-item-style-2 -->
					<!--/div>
					<!-- /col-md-2 client-block -->
					<!-- col-md-2 client-block -->
					<!--div class="col-md-2 col-xs-6 col-sm-4 client-block">
						<!-- client-item client-item-style-2 -->
						<!--div class="client-item client-item-style-2">
							<a title="Client Logo" href="#">
								<img alt="Clients Logo" src="images/clients/client_10.png">
							</a>
						</div>
						<!-- /client-item client-item-style-2 -->
					</div>
					<!-- /col-md-2 client-block -->
				<!--/div>
				<!-- Row End -->
			<!--/div>
			<!-- end container -->
		<!--/section>
		<!-- =-=-=-=-=-=-= Our Clients -end =-=-=-=-=-=-= -->
        
		<!-- =-=-=-=-=-=-= Download Apps =-=-=-=-=-=-= -->
		<!--div class="parallex section-padding  our-apps text-center">
			<div class="container">
				<!-- title-section -->
				<!--div class="main-heading text-center">
					<h2>Download Our Apps</h2>
					<hr class="main">
				</div>
				<!-- End title-section -->
				<!--div class="row">
					<div class="app-content">
						<!-- Single download start \-->
						<!--div class="col-md-4 col-sm-4">
							<a href="#" class="app-grid"> <span class="app-icon"> <img alt="#" src="images/mobile.png"> </span>
								<div class="app-title">
									<h5>Available on the</h5>
									<h3>iOS App Store</h3>
								</div>
							</a>
						</div>
						<!--/ Single download end-->
						<!-- Single download start \-->
						<!--div class="col-md-4 col-sm-4">
							<a href="#" class="app-grid"> <span class="app-icon"> <img alt="#" src="images/play-store.png"> </span>
								<div class="app-title">
									<h5>Available on the</h5>
									<h3>Google Store</h3>
								</div>
							</a>
						</div>
						<!--/ Single download end-->
						<!-- Single download start \-->
						<!--div class="col-md-4  col-sm-4">
							<a href="#" class="app-grid"> <span class="app-icon"> <img alt="#" src="images/windows.png"> </span>
								<div class="app-title">
									<h5>Available on the</h5>
									<h3>Windows Store</h3>
								</div>
							</a>
						</div>
						<!--/ Single download end-->
					<!--/div>
				</div>
				<!-- End row -->
			<!--/div>
			<!-- end container -->
		<!--/div>
		<!-- =-=-=-=-=-=-= Download Apps END =-=-=-=-=-=-= -->
        
	<!--/div>
	<!-- =-=-=-=-=-=-= Main Area End =-=-=-=-=-=-= -->
	<!--section id="social-media">
		<div class="block no-padding">
			<div class="row">
				<div class="col-md-12">
					<div class="social-bar">
						<ul>
							<li class="social1">
								<a title="" href="#">
									<img alt="" src="images/facebook.png"> <span>Join Us On<strong>FACEBOOK</strong></span> 
								</a>
							</li>
							<li class="social2">
								<a title="" href="#">
									<img alt="" src="images/twitter.png"> <span>Join Us On<strong>TWIITER</strong></span> 
								</a>
							</li>
							<li class="social3">
								<a title="" href="#">
									<img alt="" src="images/google-plus.png"> <span>Join Us On<strong>GOOGLE PLUS</strong></span> 
								</a>
							</li>
							<li class="social4">
								<a title="" href="#">
									<img alt="" src="images/linkedin.png"> <span>Join Us On<strong>LINKED IN</strong></span> 
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- =-=-=-=-=-=-= FOOTER =-=-=-=-=-=-= -->
	<!--footer class="footer-area">
		<!--Footer Upper-->
		<!--div class="footer-content">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-8 col-md-offset-2">
						<div class="footer-content text-center no-padding margin-bottom-40">
							<div class="logo-footer">
								<img id="logo-footer" class="center-block" src="images/logo-1.png" alt="">
							</div>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Necessitatibus illo vel dolorum soluta consectetur doloribus sit. Delectus non tenetur odit dicta vitae debitis suscipit doloribus. Lorem ipsum dolor sit amet, illo vel.</p>
						</div>
					</div>
					<!--Two 4th column-->
					<!--div class="col-md-6 col-sm-12 col-xs-12">
						<div class="row clearfix">
							<div class="col-lg-7 col-sm-6 col-xs-12 column">
								<div class="footer-widget about-widget">
									<h2>Our Addres</h2>
									<ul class="contact-info">
										<li><span class="icon fa fa-map-marker"></span> 60 Link Road Lhr. Pakistan 54770</li>
										<li><span class="icon fa fa-phone"></span> (042) 1234567890</li>
										<li><span class="icon fa fa-map-marker"></span> contant@scriptsbundle.com</li>
										<li><span class="icon fa fa-fax"></span> (042) 1234 7777</li>
									</ul>
									<div class="social-links-two clearfix">
										<a href="#" class="facebook img-circle">	<span class="fa fa-facebook-f"></span>
										</a>
										<a href="#" class="twitter img-circle">	<span class="fa fa-twitter"></span>
										</a>
										<a href="#" class="google-plus img-circle">	<span class="fa fa-google-plus"></span>
										</a>
										<a href="#" class="linkedin img-circle"> <span class="fa fa-pinterest-p"></span>
										</a>
										<a href="#" class="linkedin img-circle">	<span class="fa fa-linkedin"></span>
										</a>
									</div>
								</div>
							</div>
							<!--Footer Column-->
							<!--div class="col-lg-5 col-sm-6 col-xs-12 column">
								<h2>Our Service</h2>
								<div class="footer-widget links-widget">
									<ul>
										<li><a href="#">Web Development</a>
										</li>
										<li><a href="#">Web Designing</a>
										</li>
										<li><a href="#">Android Development</a>
										</li>
										<li><a href="#">Theme Development</a>
										</li>
										<li><a href="#">IOS Development</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!--Two 4th column End-->
					<!--Two 4th column-->
					<!--div class="col-md-6 col-sm-12 col-xs-12">
						<div class="row clearfix">
							<!--Footer Column-->
							<!--div class="col-lg-7 col-sm-6 col-xs-12 column">
								<div class="footer-widget news-widget">
									<h2>Latest News</h2>
									<!--News Post-->
									<!--div class="news-post">
										<div class="icon"></div>
										<div class="news-content">
											<figure class="image-thumb">
												<img src="images/blog/popular-2.jpg" alt="">
											</figure> <a href="#">If you need a crown or lorem an implant you will pay it gap it</a>
										</div>
										<div class="time">July 2, 2014</div>
									</div>
									<!--News Post-->
									<!--div class="news-post">
										<div class="icon"></div>
										<div class="news-content">
											<figure class="image-thumb">
												<img src="images/blog/poFpular-1.jpg" alt="">
											</figure> <a href="#">If you need a crown or lorem an implant you will pay it gap it</a>
										</div>
										<div class="time">July 2, 2014</div>
									</div>
								</div>
							</div>
							<!--Footer Column-->
							<!--div class="col-lg-5 col-sm-6 col-xs-12 column">
								<div class="footer-widget links-widget">
									<h2>Site Links</h2>
									<ul>
										<li><a href="login.jsp">Login</a>
										</li>
										<li><a href="register.jsp">Register</a>
										</li>
										<li><a href="listing.jsp">Listing</a>
										</li>
										<li><a href="blog.jsp">Blog</a>
										</li>
										<li><a href="contact.jsp">Contact Us</a>
										</li>

									</ul>
								</div>
							</div>
						</div>
					</div>
					<!--Two 4th column End-->
				<!--</div>
			</div>
		</div>//-->
		<!--Footer Bottom-->
		<div class="footer-copyright">
			<div class="auto-container clearfix">
				<!--Copyright-->
				<div class="copyright text-center">Copyright 2019 &copy; Theme Created By <a>IIPS DAVV</a> All Rights Reserved</div>
			</div>
		</div>
	</footer>
	<!-- =-=-=-=-=-=-= JQUERY =-=-=-=-=-=-= -->
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<!-- Bootstrap Core Css  -->
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<!-- Jquery Smooth Scroll  -->
	<script src="<c:url value="/resources/js/jquery.smoothscroll.js"/>"></script>
	<!-- Jquery Easing -->
	<script type="text/javascript" src="<c:url value="/resources/js/easing.js"/>"></script>
	<!-- Jquery Counter -->
	<script src="<c:url value="/resources/js/jquery.countTo.js"/>"></script>
	<!-- Jquery Waypoints -->
	<script src="<c:url value="/resources/js/jquery.waypoints.js"/>"></script>
	<!-- Jquery Appear Plugin -->
	<script src="<c:url value="/resources/js/jquery.appear.min.js"/>"></script>
	<!-- Carousel Slider  -->
	<script src="<c:url value="/resources/js/carousel.min.js"/>"></script>
	<!-- Jquery Parallex -->
	<script src="<c:url value="/resources/js/jquery.stellar.min.js"/>"></script>
	<!--Style Switcher -->
	<script src="<c:url value="/resources/js/bootstrap-dropdownhover.min.js"/>"></script>
	<!-- Include jQuery Syntax Highlighter -->
	<script type="text/javascript" src="<c:url value="/resources/scripts/shCore.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/scripts/shBrushPhp.js"/>"></script>
	<!-- Template Core JS -->
	<script src="<c:url value="/resources/js/custom.js"/>"></script>
</body>


<!-- Mirrored from templates.scriptsbundle.com/knowledge/demo/index.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 07:34:51 GMT -->
</html>