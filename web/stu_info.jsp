<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/my_css.css">
</head>
<body>
<div>
    <div class="row clearfix">
        <div style="margin-left: 1cm; margin-top: 0.5cm">
            <table class="table table-condense table-bordered" style="width: 500px;">
                <tr>
                    <th>个人照片</th>
                    <td>
                        <c:if test="${not empty sessionScope.img}">
                            <img class="img-responsive" style="width: 70px; height: 70px" src="${sessionScope.img}">
                        </c:if>
                    </td>
                </tr>
                <c:forEach items="${sessionScope.studentInfoList}" var="studentInfo">
                    <tr>
                        <th><c:out value="${studentInfo.infoName}"/></th>
                        <td><c:out value="${studentInfo.info}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/my_js.js"></script>
</body>
</html>
