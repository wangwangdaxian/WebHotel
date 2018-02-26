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
            <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="management.jsp" class="pure-menu-link">入住管理</a></li>
            <li class="pure-menu-item"><a href="check_out.jsp" class="pure-menu-link">退房处理</a></li>
            <li class="pure-menu-item"><a href="fix_report.jsp" class="pure-menu-link">维修报告</a></li>
            <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link">返回</a></li>
          </ul>
        </div>
      </div>

      <div id="main">
        <div class="header">
          <h1>入住管理</h1>
          <h2>入住期间后续事项处理</h2>
        </div>

        <div class="content">
          <h2 class="content-subhead">房间更换</h2>
          <form class="pure-form pure-form-aligned" action="RoomChangeServlet" method="post">
            <fieldset>
              <div class="pure-control-group">
                <label for="oldRoomId">旧房间号</label>
                <input id="oldRoomId" type="number" placeholder="更换前房间号" name="oldRoomId">
              </div>

              <div class="pure-control-group">
                <label for="newRoomId">新房间号</label>
                <input id="newRoomId" type="number" placeholder="更换后房间号" name="newRoomId">
              </div>

              <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary" value="确认">确认</button>
              </div>
            </fieldset>
          </form>
          ${requestScope.msg1}

          <h2 class="content-subhead">房间续订</h2>
          <form class="pure-form pure-form-aligned" action="OutDateChangeServlet" method="post">
            <fieldset>
              <div class="pure-control-group">
                <label for="RoomId">房间号</label>
                <input id="RoomId" type="number" placeholder="当前入住房间号" name="RoomId">
              </div>

              <div class="pure-control-group">
                <label for="newOutDate">续订至</label>
                <input id="newOutDate" type="text" placeholder="格式:2017-12-12" name="newOutDate">
              </div>

              <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary" value="确认">确认</button>
              </div>
            </fieldset>
          </form>
          ${requestScope.msg2}

        </div>
      </div>
      </div>

    <script src="js/ui.js"></script>
  </body>
</html>
