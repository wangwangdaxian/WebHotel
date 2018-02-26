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
            <li class="pure-menu-item"><a href="check_in_pre.jsp" class="pure-menu-link">预定入住</a></li>
            <li class="pure-menu-item"><a href="check_in_cur.jsp" class="pure-menu-link">散客入住</a></li>
            <li class="pure-menu-item"><a href="management.jsp" class="pure-menu-link">入住管理</a></li>
            <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="check_out.jsp" class="pure-menu-link">退房处理</a></li>
            <li class="pure-menu-item"><a href="fix_report.jsp" class="pure-menu-link">维修报告</a></li>
          <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link">返回</a></li>
          </ul>
        </div>
      </div>

      <div id="main">
        <div class="header">
          <h1>退房处理</h1>
          <h2>办理退房手续并打印账单</h2>
        </div>

        <div class="content">
          <h2 class="content-subhead">退房手续</h2>
          <form class="pure-form" action="CheckOutServlet" method="post">
            <fieldset>
              <label>房间号</label>
              <input type="number" placeholder="" name="roomId">
              <button type="submit" class="pure-button pure-button-primary">确定</button>
            </fieldset>
          </form>

          <h2 class="content-subhead">打印账单</h2>
          <c:if test="${!empty requestScope.check }">
          <table class="pure-table pure-table-horizontal">
            <thead>
            <tr>
              <th>订单编号</th>
              <th>顾客ID</th>
              <th>顾客姓名</th>
              <th>房间号</th>
              <th>单价（元/天）</th>
            </tr>
            </thead>

            <tbody>
            <tr>
              <td>${check.orderId }</td>
              <td>${check.custId }</td>
              <td>${check.custName }</td>
              <td>${check.roomId }</td>
              <td>${check.roomPrice }</td>
            </tr>

            <thead>
            <tr>
              <th>入住时间</th>
              <th>退房时间</th>
              <th>总消费（元）</th>
              <th>结账处理人</th>
              <th>当前时间</th>
            </tr>
            </thead>

            <tbody>
            <tr>
              <td>${check.inDate }</td>
              <td>${check.outDate }</td>
              <td>${check.totalPrice }</td>
              <td>${check.admsName }</td>
              <td>${check.dnow }</td>
            </tr>


            </tbody>
          </table>
          </c:if>

        </div>
      </div>
      </div>


    <script src="js/ui.js"></script>
  </body>
</html>
