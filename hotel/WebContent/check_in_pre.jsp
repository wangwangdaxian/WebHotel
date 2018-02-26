<%--
  Created by IntelliJ IDEA.
  User: ziweichen
  Date: 2018/1/3
  Time: 上午8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A layout example with a side menu that hides on mobile, just like the Pure website.">

    <title>酒店后台管理系统</title>

    <link rel="stylesheet" href="css/pure.css">
    <link rel="stylesheet" href="css/side-menu.css">
  </head>
  <body>
    <div id="layout">
      <!-- Menu toggle -->
      <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
      </a>

      <div id="menu">
        <div class="pure-menu">
          <a class="pure-menu-heading" href="Receindex.jsp">酒店后台管理</a>

          <ul class="pure-menu-list">
            <li class="pure-menu-item"><a href="Receindex.jsp" class="pure-menu-link">前台管理-首页</a></li>
            <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="check_in_pre.jsp" class="pure-menu-link">预定入住</a></li>
            <li class="pure-menu-item"><a href="check_in_cur.jsp" class="pure-menu-link">散客入住</a></li>
            <li class="pure-menu-item"><a href="management.jsp" class="pure-menu-link">入住管理</a></li>
            <li class="pure-menu-item"><a href="check_out.jsp" class="pure-menu-link">退房处理</a></li>
            <li class="pure-menu-item"><a href="fix_report.jsp" class="pure-menu-link">维修报告</a></li>
          <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link">返回</a></li>
          </ul>
        </div>
      </div>

      <div id="main">
        <div class="header">
          <h1>预定入住</h1>
          <h2>根据预订单为客人安排可用房间</h2>
        </div>

        <div class="content">
          <h2 class="content-subhead">查询预订单</h2>
          <form class="pure-form" action="AdOrQueryServlet" method="post">
            <fieldset>
              <label>身份证号</label>
              <input type="text" placeholder="15-18位" name="userId">
              <button type="submit" class="pure-button pure-button-primary">查询</button>
            </fieldset>
          </form>

          <h2 class="content-subhead">查询结果</h2>
          
            <c:if test="${!empty sessionScope.AdOrList}">
              <table class="pure-table pure-table-horizontal">
                <thead>
                <tr>
                  <th>预订单号</th>
                  <th>顾客ID</th>
                  <th>顾客姓名</th>
                  <th>房间类型</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="ao" varStatus="status" items="${sessionScope.AdOrList }">
                <tr>
                  <td>${ao.orderId}</td>
                  <td>${ao.custId}</td>
                  <td>${ao.custName}</td>
                  <td>${ao.roomType}</td>
                </tr>
                </c:forEach>
                </tbody>

                <thead>
                <tr>
                  <th>单价（元/天）</th>
                  <th>入住时间</th>
                  <th>退房时间</th>
                  <th>总价（元）</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="ao" varStatus="status" items="${sessionScope.AdOrList }">
                  <tr>
                    <td>${ao.roomPrice}</td>
                    <td>${ao.inDate}</td>
                    <td>${ao.outDate}</td>
                    <td>${ao.totalPrice}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </c:if>
              <span class="pure-form-message-inline">${requestScope.msg1}</span>


          <h2 class="content-subhead">查询可用房</h2>
          <form class="pure-form" action="AvaiRoomQueryServlet" method="post">
            <fieldset>
              <label>房间类型</label>
              <input type="text" placeholder="" name="roomType">
              <button type="submit" class="pure-button pure-button-primary">查询</button>
            </fieldset>
          </form>

          <h2 class="content-subhead">查询结果</h2>
            <c:if test="${!empty sessionScope.roomList }">
              <table class="pure-table pure-table-horizontal">
                <thead>
                <tr>
                  <th>房间号</th>
                  <th>房间类型</th>
                  <th>楼层</th>
                  <th>朝向</th>
                  <th>特征描述</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="room" varStatus="status" items="${sessionScope.roomList}">
                  <tr>
                    <td>${room.roomId}</td>
                    <td>${room.roomType}</td>
                    <td>${room.roomFloor}</td>
                    <td>${room.orientation}</td>
                    <td>${room.feature}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </c:if>
              <span class="pure-form-message-inline">${requestScope.msg2 }</span>


          <h2 class="content-subhead">安排房间</h2>
          <form class="pure-form" action="AssignRoomServlet" method="post">
            <fieldset>
              <legend>输入信息</legend>

              <input type="number" placeholder="订单号" name="AdOrId">
              <input type="number" placeholder="房间号" name="roomId">

              <button type="submit" class="pure-button pure-button-primary" value="提交">提交</button>
              
            </fieldset>
          </form>
           <span class="pure-form-message-inline"> ${requestScope.msg3 }</span>



        </div>
      </div>
      </div>

    <script src="js/ui.js"></script>
  </body>
</html>
