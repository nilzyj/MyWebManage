<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/24
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/my_css.css">
</head>
<body>
<div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <p class="lead" style="margin-top: 10px;margin-bottom: 0px">考生报考信息列表</p>
            <%--考生查询--%>
            <form class="form-inline navbar-left" style="margin-top: 10px">
                <div class="form-group">
                    <input type="number" class="form-control" id="searchYear" placeholder="报考年份：2000">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="searchName" placeholder="考生姓名：张三">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="searchbaokaodian" placeholder="报考点：山东">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" id="searchbaokaohao" placeholder="报考号：111110001">
                </div>
                <button id="searchBtn" type="button" class="btn btn-default btn-primary">查询</button>
                <button id="clearBtn" type="button" class="btn btn-default btn-primary">清除</button>
                <c:out value="${sessionScope.searchResult}"/>
            </form>

            <%--显示考生信息--%>
            <table class="table table-bordered table-hover table-condensed" style="margin-top: 2cm;">
                <thead>
                <tr>
                    <th>考生序号</th>
                    <th>报考年份</th>
                    <th>考生姓名</th>
                    <th>报考点</th>
                    <th>报考号</th>
                    <th>信息操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.list}" var="info">
                    <tr>
                        <td><c:out value="${info.ID}"/></td>
                        <td><c:out value="${info.year}"/></td>
                        <td><c:out value="${info.name}"/></td>
                        <td><c:out value="${info.baokaodian}"/></td>
                        <td><c:out value="${info.baokaohao}"/> </td>
                        <td><a href="stu_info.jsp" role='button' class='btn'>查看</a>
                        <a href="stu_info_modify.jsp" role='button' class='btn'>修改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/my_js.js"></script>
</body>
</html>
