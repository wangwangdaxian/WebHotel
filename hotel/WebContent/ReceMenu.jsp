<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty sessionScope.adms}">
	欢迎你，${sessionScope.adms.name}!<br>
	<a href="Login.jsp">返回登陆界面</a><br>
	1.查询预订单<br>
	<form action="AdOrQueryServlet" method="post">
	请输入顾客身份证号：<input type="text" name="userId">
	<input type="submit" value="确认">
	</form>
	<c:if test="${!empty sessionScope.flag1 }">
		<c:if test="${!empty sessionScope.AdOrList}">
			查询到的预订单如下：<br>
			<table border="1">
					<tr>
						<td>预订单号</td><td>顾客姓名</td><td>顾客身份证号</td><td>房间类型</td>
						<td>单价(元/天)</td><td>入住日期</td><td>离房日期</td><td>总价(元)</td>
					</tr>
					<c:forEach var="ao" varStatus="status" items="${sessionScope.AdOrList }">
						<tr>
							<td>${ao.orderId}</td><td>${ao.custName}</td><td>${ao.custId}</td><td>${ao.roomType}</td>
							<td>${ao.roomPrice}</td><td>${ao.inDate}</td><td>${ao.outDate}</td><td>${ao.totalPrice}</td>
						</tr>
					</c:forEach>
			</table>
			
		</c:if>
		<c:if test="${empty sessionScope.AdOrList}">
			对不起，没有找到该顾客的预订单！<br>
		</c:if>
	</c:if>
	2.查询可用房间<br>
	<form action="AvaiRoomQueryServlet" method="post">
	输入需要查询的房间类型:<input type="text" name="roomType">
	<input type="submit" value="确认">
	</form>
	<c:if test="${!empty sessionScope.flag2 }">
			<c:if test="${!empty sessionScope.roomList }">
			可用的房间如下:<br>
			<table border="1">
					<tr>
						<td>房间号</td><td>房间类型</td><td>楼层</td><td>朝向</td><td>特征</td>
					</tr>
					<c:forEach var="room" varStatus="status" items="${sessionScope.roomList}">
						<tr>
							<td>${room.roomId}</td><td>${room.roomType}</td><td>${room.roomFloor}</td>
							<td>${room.orientation}</td><td>${room.feature}</td>
						</tr>
					</c:forEach>
			</table>
			</c:if>
			<c:if test="${empty sessionScope.roomList }">
						抱歉！当前房间已满！<br>
			</c:if>
	</c:if>
	3.分配房间<br>
	<form action="AssignRoomServlet" method="post">
	请输入订单号<input type="text" name="AdOrId"><br>
	请输入房间号<input type="text" name="roomId"><br>
	<input type="submit" value="提交">
	</form>
	<c:if test="${!empty sessionScope.flag3}">
		<c:if test="${sessionScope.assignResult==true}">
			入住成功！
		</c:if>
		<c:if test="${sessionScope.assignResult==false}">
			入住失败！请重试！
		</c:if>
	</c:if>
	4.退房处理<br>
	<form action="CheckOutServlet" method="post">
	请输入房间号<input type="text" name="roomId"><br>
	<input type="submit" value="确认">
	</form>
	<c:if test="${!empty requestScope.check }">
		账单如下：<br>
		<table border="1">
			<tr>
				<td>订单编号</td><td>顾客ID</td><td>顾客姓名</td><td>房间号</td><td>房间类型</td>
				<td>单价（元/天）</td><td>入住时间</td><td>离房时间</td><td>总消费（元）</td>
				<td>结账处理人</td><td>当前时间</td>
			</tr>
			<tr>
				<td>${check.orderId}</td><td>${check.custId }</td><td>${check.custName }</td><td>${check.roomId }</td>
				<td>${check.roomType }</td><td>${check.roomPrice }</td><td>${check.inDate }</td><td>${check.outDate }</td>
				<td>${check.totalPrice }</td><td>${check.admsName }</td><td>${check.dnow }</td>
			</tr>
		</table>
	</c:if>
5.故障维修<br>
<form action="BadRoomServlet" method="post">
哪个房间坏了啊！<input type="text" name="roomId">
<input type="submit" value="就是这个！">
</form>
${requestScope.brResult}
6.散客入住<br>
	<form action="IndividualCustServlet" method="post">
		账号(身份证号)<input type="text" name="userId"><br>
		姓名<input type="text" name="username"><br>
		密码<input type="password" name="password"><br>
		手机号码<input type="text" name="phone"><br>
		入住时间(格式:2017-12-12)<input type="text" name="inDate"><br>
		离房时间<input type="text" name="outDate"><br>
		房间类型<input type="text" name="roomType"><br>
		房间号<input type="text" name="roomId"><br>
		<input type="submit" value="确认">
	</form>
	${requestScope.message}
</c:if>
<c:if test="${empty sessionScope.adms}">
	会话已失效!请重新登陆！
	<a href="Login.jsp">重新登陆</a>
</c:if>
</body>
</html>