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
							<br>
							<span></span>
						</div>
					</header>
					<div class="box">
						<nav>
							<ul id="menu">
							<li ><a href="ManaIndex.jsp">BsicSet</a></li>
							<li class="active"><a href="ManaStatics.jsp">Statics</a></li>
							<li><a href="ManaReceAccount.jsp">RceAct</a></li>
							<li ><a href="ManaRoomControl.jsp">RoCtrl</a></li>
							<li ><a href="ManaCustHere.jsp">CstHere</a></li>
								
								
							</ul>
						</nav>
<!-- header end -->
<!-- content -->
						<article id="content">
							<div class="box1">
								<div class="wrapper">
									<form action="StateStaticsServlet" id="form1" method="post">
										<h2>StateStatistics</h2>
										<fieldset>	
											<div class="row">
												<div class="select1"><select name='roomType'><option value='null' selected>--请选择--</option><option value="标准间"  >标准间</option><option value="豪华间">豪华间</option></select></div>
												客房类型:
											</div>	
											<div class="row">
												<div class="select1"><select name='roomFloor'><option value='null' selected>--请选择--</option><option value="1" >一层</option><option value="2">二层</option></select></div>
												楼层:
											</div>	
											<div class="wrapper">
												<input type='submit' value='Send' class="button1">
											</div>
											<div class="row">
											</div>	
											<div class="row">
											</div>
										</fieldset>
									</form>
									
									
									<div class="col2 pad">
										<h2><img src="images/title_marker1.jpg" alt="">RoomStateStatistics</h2>
										<c:if test="${! empty requestScope.showList }">
										<table class="table">
											<thead>
												<tr><th>RoomId</th><th>RoomFloor</th><th>TypeName</th><th>RoomState</th></tr>
											</thead>
											<tbody>
											<c:forEach var="r" varStatus="status" items="${requestScope.showList}">
												<tr><td>${r.roomId }</td><td>${r.roomFloor }</td><td>${r.roomType }</td><td>${r.situation }</td></tr>
											</c:forEach>
											</tbody>
										</table>
										</c:if>
									</div>
								</div>
								
							</div>
							<div class="pad">
								<h2></h2>
								<div class="line2"><div class="wrapper line3">
									<div class="col1">
										<p class="pad_bot1"><strong class="color2"></strong></p>
										<p class="pad_bot1"></p>
										<p class="cols">
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
							<li></li>
							<li ></li>
							<li></li>
							<li></li>
							<li></li>
						</ul>
					</nav>
				</div>
				<div class="col1 pad_left1">
					<ul id="icons">
						<li><img src="images/icon1.jpg" alt=""></li>
						<li><img src="images/icon2.jpg" alt=""></li>
						<li><img src="images/icon3.jpg" alt=""></li>
						<li><img src="images/icon4.jpg" alt=""></li>
					</ul>
				</div>				
				<!-- {%FOOTER_LINK} -->
			</footer>
<!-- footer end -->
		</div>
		<script type="text/javascript"> Cufon.now(); </script>
	</body>
</html>