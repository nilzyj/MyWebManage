<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Util.DbUtil" %><%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/26
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/my_css.css">
</head>
<body>
<div class="row clearfix">
    <div class="col-md-12 column">
        <p class="lead">管理员账户信息</p>
        <table class="table table-bordered table-hover table-condensed" style="margin-top: 1cm;">
            <thead>
            <tr>
                <th>序号</th>
                <th>管理员用户名</th>
                <th>管理员密码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.userList}" var="user">
                <tr>
                    <td>${user.ID}</td>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <%--遮罩窗体，弹出的修改框--%>
        <div class="modal fade" id="modal-container-325223" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                            管理员信息修改
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="ModifyExamInfo">
                            <div class="form-group">
                                <label for="examAddr">管理员用户名</label>
                                <input type="text" class="form-control" id="examAddr" placeholder="管理员用户名">
                            </div>
                            <div class="form-group">
                                <label for="examTime">管理员信息</label>
                                <input type="text" class="form-control" id="examTime" placeholder="管理员信息">
                            </div>
                            <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary">确定</button>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>
<script type="text/javascript" src="./js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/my_js.js"></script>
</body>
</html>
