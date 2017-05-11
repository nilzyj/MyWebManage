<%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/17
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="js no-touch" style="overflow: hidden;" lang="zxx">
<head>
    <title>Admin Login </title>
    <!-- custom-theme -->
    <%--width：可视区域的宽度--%>
    <%--intial-scale:页面首次被显示是可视区域的缩放级别，取值1.0则页面按实际尺寸显示，无任何缩放--%>
    <%--meta是html中的元标签--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- /custom-theme -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>
<!-- banner -->
<div class="position_relative">
    <!-- inner_content-->
    <div class="inner_content">
        <!-- inner_content_margin_top-->
        <div class="inner_content_margin_top">
            <%--padding_top_bottom_1em--%>
            <div class="registration admin_agile">
                <%--中间的方形--%>
                <div class="signin-form profile admin">
                    <h2>Admin Login</h2>
                    <div class="login-form">
                        <form action="ManageLoginServlet" method="post">
                            <input name="name" value="a" required=""
                                   style="background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: pointer;"
                                   type="text">
                            <input name="password" value="a" required=""
                                   style="background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: auto;"
                                   type="password">
                            <div class="tp">
                                <input value="LOGIN" type="submit">
                            </div>
                        </form>
                    </div>
                </div>
                <%--/中间的方形--%>
            </div>
            <%--/padding_top_bottom_1em--%>
        </div>
        <!-- /inner_content_margin_top-->
    </div>
    <!-- /inner_content-->
</div>
<!-- /banner -->
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>
