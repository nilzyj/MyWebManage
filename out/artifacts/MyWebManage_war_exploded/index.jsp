<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>主页</title>
    <link rel="stylesheet" href="common/css/sccl.css">
    <link rel="stylesheet" type="text/css" href="common/skin/qingxin/skin.css" id="layout-skin"/>
</head>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        session.setAttribute("error", "登录过期，请重新登录！");
    }
%>
<body>
<div class="layout-admin">
    <header class="layout-header">
        <span class="header-logo">网页管理端</span>
        <!--右上角菜单按钮-->
        <a class="header-menu-btn" href="javascript:;"><i class="icon-font">&#xe600;</i></a>
        <!--/右上角菜单按钮-->
        <ul class="header-bar">

            <li class="header-bar-nav">
                <a href="javascript:;"><c:out value="${sessionScope.username}"/><i class="icon-font" style="margin-left:5px;">&#xe60c;</i></a>
                <ul class="header-dropdown-menu">
                    <li><a href="javascript:;">个人信息</a></li>
                    <li><a href="javascript:;">切换账户</a></li>
                    <li><a id="logoff" href="javascript:;">退出</a></li>
                </ul>
            </li>
            <li class="header-bar-role"><a href="javascript:;">管理</a></li>
        </ul>
    </header>

    <aside class="layout-side">
        <ul class="side-menu">

        </ul>
    </aside>

    <!--左侧菜单展开和关闭按钮-->
    <div class="layout-side-arrow">
        <div class="layout-side-arrow-icon"><i class="icon-font">&#xe60d;</i></div>
    </div>
    <!--/左侧菜单展开和关闭按钮-->

    <section class="layout-main">
        <div class="layout-main-tab">
            <!--tab的左箭头-->
            <button class="tab-btn btn-left"><i class="icon-font">&#xe60e;</i></button>
            <!--/tab的左箭头-->
            <nav class="tab-nav">
                <div class="tab-nav-content">
                    <a href="javascript:;" class="content-tab active" data-id="home.html">首页</a>
                </div>
            </nav>
            <!--tab的右键头-->
            <button class="tab-btn btn-right"><i class="icon-font">&#xe60f;</i></button>
            <!--/tab的右键头-->
        </div>

        <div class="layout-main-body">
            <iframe class="body-iframe" name="iframe0" width="100%" height="99%" src="home.jsp" frameborder="0"
                    data-id="home.html" ></iframe>
        </div>
    </section>

    <div class="layout-footer">Copyright ©2017 张殷杰 All Rights Reserved.</div>

</div>
<script type="text/javascript" src="common/lib/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="common/js/sccl.js"></script>
<script type="text/javascript" src="common/js/sccl-util.js"></script>
<%--<script type="text/javascript" src="js/jquery-3.1.1.js"></script>--%>
<script type="text/javascript" src="js/my_js.js"></script>
</body>
</html>
