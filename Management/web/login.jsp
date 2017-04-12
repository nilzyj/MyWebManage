<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/my_css.css">
    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/my_js.js"></script>
</head>
</head>e
<% String loginState = (String) session.getAttribute("loginState"); %>
<body>
<div class="container">
    <div class="row clearfix text-center" style="margin-top: 200px;font-size: 20px">
        <strong>网页管理端</strong>
    </div>
    <div class="row clearfix" style="margin-top: 60px">
        <div class="col-md-3">

        </div>
        <div class="col-md-6 column">
            <form class="form-horizontal" role="form" method="post"
                  action="http://localhost:8080/Manage/ManageLoginServlet">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input class="form-control" id="name" name="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">密码：</label>

                    <div class="col-sm-10">
                        <input class="form-control" id="inputPassword" type="password" name="pwd"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox"/>记住密码</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" id="commit">确定</button>
                        <%--<a href="home.jsp"> 确定</a>--%>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>



</body>
</html>