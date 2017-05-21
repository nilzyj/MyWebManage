<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Util.DbUtil" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="com.google.gson.JsonParser" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/26
  Time: 15:09
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
<div>
    <div class="row clearfix">
        <div class="col-md-12">
            <div style="margin-left: 3cm; margin-top: 3cm">
                <div id="back" class="back btn btn-primary" href="javascript:;">
                    <img src="image/back.png"><span class="lead">返回</span>
                </div>
                <table class="table table-bordered" style="width: 800px;">
                    <c:forEach items="${sessionScope.studentInfoList}" var="studentInfo">
                        <tr>
                            <th><p class="lead"><c:out value="${studentInfo.infoName}"/></p></th>
                            <td><c:out value="${studentInfo.info}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="./js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/my_js.js"></script>
</body>
</html>
