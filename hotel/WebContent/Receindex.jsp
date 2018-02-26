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
            <li class="pure-menu-item menu-item-divided pure-menu-selected"><a href="Receindex.jsp" class="pure-menu-link">前台管理-首页</a></li>
            <li class="pure-menu-item"><a href="check_in_pre.jsp" class="pure-menu-link">预定入住</a></li>
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
          <h1>欢迎使用,${sessionScope.rece.name}</h1>
          <h2>酒店后台管理系统</h2>
        </div>

        <div class="content">
          <h2 class="content-subhead">使用说明</h2>
          <p>
            请通过左侧侧边栏选择要进行的操作。
          </p>

          <h2 class="content-subhead">相关信息</h2>
          <p>
          </p>

        </div>
      </div>
      </div>

    <script src="js/ui.js"></script>
  </body>
</html>
