<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title></title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
		<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
		<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
		<script type="text/javascript" src="js/jquery-1.6.js" ></script>
		<script type="text/javascript" src="js/cufon-yui.js"></script>
		<script type="text/javascript" src="js/cufon-replace.js"></script>  
		<script type="text/javascript" src="js/Adamina_400.font.js"></script>
		<script type="text/javascript" src="js/jquery.jqtransform.js" ></script>
		<script type="text/javascript" src="js/script.js" ></script>
		<script type="text/javascript" src="js/kwicks-1.5.1.pack.js" ></script>
		<script type="text/javascript" src="js/atooltip.jquery.js"></script>
		<!--[if lt IE 9]>
			<script type="text/javascript" src="js/html5.js"></script>
			<link rel="stylesheet" href="css/ie.css" type="text/css" media="all">
		<![endif]-->
		<!--[if lt IE 7]>
			<div style=' clear: both; text-align:center; position: relative;'>
				<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." /></a>
			</div>
		<![endif]-->
	</head>
	<body id="page1">
		<div class="bg1">
			<div class="bg2">
				<div class="main">
<!-- header -->
					<header>
						<h1><a href="index.jsp" id="logo">LoungeHotel</a></h1>
						<div class="department">
							9863 - 9867 Mill Road, LA, MG09 99HT<br>
							<span>Freephone: &nbsp;  +1 800 559 6580</span>
						</div>
					</header>
					<div class="box">
						<nav>
							<ul id="menu">
								<li class="active"><a href="index.jsp">About Us</a></li>
								<li><a href="Register.jsp">Register</a></li>
								<li><a href="Rooms.html">Rooms</a></li>
								<li><a href="Booking.jsp">Booking</a></li>
								<li><a href="Order.jsp">Order</a></li>
							</ul>
						</nav>
<!-- header end -->
<!-- content -->
						<article id="content">
							<div class="box1">
								<div class="wrapper">
									<form action="LoginServlet" id="form1" method='post'>
										<h2>Login</h2>
										<fieldset>
											<div class="row">
												<input type="text" class="input" name='userId'>
												UserID:
											</div>	
											<div class="row">
												<input type="password" class="input" name='password'>
												Password:
											</div>
											<div class="row">
												<div class="select1"><select name='usertype'><option value='customer' selected >Customer</option><option value='receptionist' >Receptionist</option><option value='manager'>Manager</option></select></div>
												Identity:
											</div>	
											<div class="wrapper">
												<input type='submit' value='Send' class="button1">
												<input type='reset' value='Clear' class="button1">
											</div>
											<div class="row"></div>
										</fieldset>
										<h2>${requestScope.msg }</h2>
										<c:if test="${! empty sessionScope.cust}">
										<div class="row">
										Welcome,${sessionScope.cust.name }!
										</div>
										</c:if>
									</form>
									
									<div class="kwicks-wrapper marg_bot1">
										<ul class="kwicks horizontal">
											<li><img src="images/img1.jpg" alt=""></li>
											<li><img src="images/img2.jpg" alt=""></li>
											<li><img src="images/img3.jpg" alt=""></li>
											<li><img src="images/img4.jpg" alt=""></li>
										</ul>
									</div>
								</div>
								<div class="pad">
									<div class="line1"><div class="wrapper line2">
										<div class="col1">
											<h2><img src="images/title_marker1.jpg" alt="">Best Rates</h2>
											<p class="pad_bot1">Lounge Hotel is one of the best fivestars hotels.It has a long history in England.</p>
											<a href="#" class="color1">Read More</a>
										</div>
										<div class="col1 pad_left1">
											<h2><img src="images/title_marker2.jpg" alt="">Hotel Guide</h2>
											<p class="pad_bot1">There are three hotel guides to make you feel like home.If you have any questions,ask the guides.</p>
											<a href="#" class="color1">Read More</a>
										</div>
										<div class="col1 pad_left1">
											<h2><img src="images/title_marker3.jpg" alt="">Packages</h2>
											<p class="pad_bot1">We have the service which can pack your bag if you want to go for a trip wtihout that heavy.</p>
											<a href="#" class="color1">Read More</a>
										</div>
									</div></div>
								</div>
							</div>
							<div class="pad">
								<div class="wrapper line3">
									<div class="col2">
										<h2>Welcome to Our Hotel!</h2>
										<p class="pad_bot1"><strong class="color2">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor</strong><br>
												Incididunt ut labore dolore magna. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
										<p class="pad_bot2">
												Duis aute irure dolorin reprehenderit in voluptate velit esse cillum dolore eu fugiat pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem.</p>
										<a href="#" class="button1">Read More</a>
									</div>
									<div class="col1 pad_left1">
										<h2>About Us</h2>
										<div class="wrapper">
											<figure class="left marg_right1"><img src="images/page1_img1.jpg" alt=""></figure>
											<p class="pad_bot1"><strong class="color2">12.12.2017</strong></p>
											<p class="pad_bot2">
													Lorem ipsum dolor sit amet, consectetur adipisicing elited do eiusmod tempor incididunt.</p>
										</div>
										<a href="#" class="button1">Read More</a>
									</div>
								</div>
							</div>
						</article>
<!--content end-->
					</div>
				</div>
			</div>
		</div>
		<div class="main">
<!-- footer -->
			<footer>
				<div class="col2">
					Lounge Hotel &copy; 2011 | More Templates
					<nav>
						<ul id="footer_menu">
							<li class="active"><a href="index.html">About Us</a></li>
							<li><a href="Register.jsp">Register</a></li>
							<li><a href="Rooms.html">Rooms</a></li>
							<li><a href="Booking.jsp">Booking</a></li>
							<li class="last"><a href="Order.jsp">Order</a></li>
						</ul>
					</nav>
				</div>
				<div class="col1 pad_left1">
					<ul id="icons">
						<li><a href="#" class="normaltip" title="Linkedin"><img src="images/icon1.jpg" alt=""></a></li>
						<li><a href="#" class="normaltip" title="Facebook"><img src="images/icon2.jpg" alt=""></a></li>
						<li><a href="#" class="normaltip" title="Picasa"><img src="images/icon3.jpg" alt=""></a></li>
						<li><a href="#" class="normaltip" title="Twitter"><img src="images/icon4.jpg" alt=""></a></li>
					</ul>
				</div>				
				<!-- {%FOOTER_LINK} -->
			</footer>
<!-- footer end -->
		</div>
		<script type="text/javascript"> Cufon.now(); </script>
		<script>
			$(document).ready(function(){
				$('.kwicks').kwicks({
					max : 500,
					spacing : 0,
					event : 'mouseover'
				});
							   
			})
		</script>
	</body>
</html>