<%--
  Created by IntelliJ IDEA.
  User: ziweichen
  Date: 2018/1/3
  Time: 上午8:56
  To change this template use File | Settings | File Templates.
--%>
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
            <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="check_in_cur.jsp" class="pure-menu-link">散客入住</a></li>
            <li class="pure-menu-item"><a href="management.jsp" class="pure-menu-link">入住管理</a></li>
            <li class="pure-menu-item"><a href="check_out.jsp" class="pure-menu-link">退房处理</a></li>
            <li class="pure-menu-item"><a href="fix_report.jsp" class="pure-menu-link">维修报告</a></li>
          <li class="pure-menu-item"><a href="index.jsp" class="pure-menu-link">返回</a></li>
          </ul>
        </div>
      </div>

      <div id="main">
        <div class="header">
          <h1>散客入住</h1>
          <h2>未预定的客人当场办理</h2>
        </div>

        <div class="content">
          <h2 class="content-subhead">信息登记</h2>
          <form class="pure-form pure-form-aligned" action="IndividualCustServlet" method="post">
            <fieldset>
              <div class="pure-control-group">
                <label for="userId">账户</label>
                <input id="userId" type="text" placeholder="请输入15-18位身份证号" name="userId">
              </div>

              <div class="pure-control-group">
                <label for="username">姓名</label>
                <input id="username" type="text" placeholder="" name="username">
              </div>

              <div class="pure-control-group">
                <label for="password">密码</label>
                <input id="password" type="password" placeholder="" name="password">
              </div>

              <div class="pure-control-group">
                <label for="phone">手机号码</label>
                <input id="phone" type="number" placeholder="请输入11位手机号" name="phone">
              </div>

              <div class="pure-control-group">
                <label for="inDate">入住时间</label>
                <input id="inDate" type="text" placeholder="格式:2017-12-12" name="inDate">
              </div>

              <div class="pure-control-group">
                <label for="outDate">退房时间</label>
                <input id="outDate" type="text" placeholder="格式:2017-12-12" name="outDate">
              </div>

              <div class="pure-control-group">
                <label for="roomType">房间类型</label>
                <input id="roomType" type="text" placeholder="" name="roomType">
              </div>

              <div class="pure-control-group">
                <label for="roomId">房间号</label>
                <input id="roomId" type="number" placeholder="" name="roomId">
              </div>

              <div class="pure-controls">
                <button type="submit" class="pure-button pure-button-primary">确认</button>
                <span class="pure-form-message-inline">${requestScope.message}</span>
              </div>
            </fieldset>
          </form>

          <h2 class="content-subhead"></h2>
          <p>
          </p>

        </div>
      </div>
      </div>


    <script src="js/ui.js"></script>
  </body>
</html>
