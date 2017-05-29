<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/5/16
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/my_css.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12">
            <table class="table table-condense table-bordered" style="margin-top: 2cm;">
                <tr>
                    <th>报名考生人数：</th>
                    <td>${sessionScope.studentNumber}</td>
                </tr>
                <tr>
                    <th>报名系统当前状态：${sessionScope.systemState}</th>
                    <td>
                        <button id="systemOn" class="btn btn-success">开启</button>
                        <button id="systemOff" class="btn btn-danger">关闭</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/my_js.js"></script>
</body>
</html>
