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
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script type="text/javascript" src="js/jquery-1.6.js" ></script>
		<script type="text/javascript" src="js/cufon-yui.js"></script>
		<script type="text/javascript" src="js/cufon-replace.js"></script>  
  		<script type="text/javascript" src="js/Adamina_400.font.js"></script>
		<script type="text/javascript" src="js/jquery.jqtransform.js" ></script>
		<script type="text/javascript" src="js/script.js" ></script>
		<script type="text/javascript" src="js/atooltip.jquery.js"></script>
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	<body id="page5">
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
								<li><a href="index.jsp">About Us</a></li>
								<li><a href="Register.jsp">Register</a></li>
								<li><a href="Rooms.html">Rooms</a></li>
								<li><a href="Booking.jsp">Booking</a></li>
								<li class="active"><a href="Order.jsp">Order</a></li>
							</ul>
						</nav>
<!-- header end -->
<!-- content -->
						<article id="content">
							<div class="box1">
								<div class="wrapper">
									<form action="CustTotalOrderServlet" id="form1" method='post'>
										<h2>Order Query</h2>
										<fieldset>	
											<div class="row">
												<div class="select1"><select name='orderType'><option value='ao' selected >Advance Order</option><option value='of' >Order Form</option></select></div>
												Order Type:
											</div>	
											<div class="wrapper">
												<input type='submit' value='Query it' class="button1">
											</div>
											<div class="row">
											</div>	
											<div class="row">
											</div>
										</fieldset>
									</form>
									<div class="col2 pad">
										<h2><img src="images/title_marker1.jpg" alt="">Order List</h2>
										<table class='table' >
										<c:if test="${requestScope.orderType eq 'ao' }">
											<thead>
												<tr><th>OrderID</th><th>RoomType</th><th>Arrival Date</th><th>Departure Date</th></tr>
											</thead>
											<tbody>
											<c:forEach var="ao" varStatus="status" items="${requestScope.OrderList}">
												<tr><td>${ao.orderId }</td><td>${ao.roomType }</td><td>${ao.inDate }</td><td>${ao.outDate }</td></tr>
											</c:forEach>
											</tbody>
										</c:if>
										<c:if test="${requestScope.orderType eq 'of' }">
											<thead>
												<tr><th>OrderID</th><th>RoomID</th><th>Arrival Date</th><th>Departure Date</th><th>OrderState</th></tr>
											</thead>
											<tbody>
											<c:forEach var="of" varStatus="status" items="${requestScope.OrderList}">
												<tr>
													<td>${of.orderId }</td><td>${of.roomId }</td>
													<td>${of.inDate }</td><td>${of.outDate }</td><td>${of.orderState }</td>
												</tr>
											</c:forEach>
											</tbody>
										</c:if>
										</table>
									</div>
								</div>
								
							</div>
							<div class="pad">
								<h2>Our Contacts</h2>
								<div class="line2"><div class="wrapper line3">
									<div class="col1">
										<p class="pad_bot1"><strong class="color2">China</strong></p>
										<p class="pad_bot1">8901 Marmora Road, Glasgow, D04</p>
										<p class="cols">
												Freephone:<br>
												Telephone:<br>
												Fax:<br>
												Email:</p>
										+1 800 559 6580<br>
										+1 800 603 6035<br>
										+1 800 889 9898<br>
										<a href="mailto:" class="color1">mail@demolink.org</a>
									</div>
								</div></div>
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
					Lounge Hotel &copy; 2011 
					<nav>
						<ul id="footer_menu">
							<li><a href="index.jsp">About Us</a></li>
							<li class="active"><a href="Register.jsp">Register</a></li>
							<li><a href="Rooms.html">Rooms</a></li>
							<li><a href="Booking.jsp">Booking</a></li>
							<li class="last"><a href="Order.html">Order</a></li>
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
	</body>
</html>