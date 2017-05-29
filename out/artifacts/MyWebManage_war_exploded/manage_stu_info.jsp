<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/my_css.css">
</head>
<body>
<div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <p class="lead" style="margin-top: 10px;margin-bottom: 0px">考生报考信息列表</p>
            <%--考生查询--%>
            <form class="form-inline navbar-left" style="margin-top: 10px">
                <div class="form-group">
                    <input type="number" class="form-control" id="searchStuYear" placeholder="报考年份：2000">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="searchStuName" placeholder="考生姓名：张三">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="searchBaokaodian" placeholder="报考点：山东">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" id="searchBaokaohao" placeholder="报考号：111110001">
                </div>
                <button id="searchStuBtn" type="button" class="btn btn-default btn-primary">查询</button>
                <button id="clearStuBtn" type="button" class="btn btn-default btn-primary">清除</button>
                ${sessionScope.searchResult}
            </form>

            <%--显示考生信息--%>
            <table class="table table-bordered table-hover table-condensed"
                   style="margin-top: 2cm; margin-bottom: 0cm;">
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
                <tbody id="student_info_tbody">
                <c:forEach begin="0" end="5" step="1" items="${sessionScope.studentList}" var="info">
                    <tr>
                        <td>${info.ID}</td>
                        <td>${info.year}</td>
                        <td>${info.name}</td>
                        <td>${info.baokaodian}</td>
                        <td>${info.baokaohao}</td>
                        <td><a href="javascript:;" role='button' class='btn showStudentInfo'>查看</a></td>
                            <%--<a href="javascript:;" role='button' class='btn modifyStudentInfo'>修改</a>--%>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="Page navigation">
                <ul class="pagination" id="pagination" style="margin-top: 1cm;">
                    <%--<li>--%>
                        <%--<a href="#" aria-label="Previous">--%>
                            <%--<span aria-hidden="true">&laquo;</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                    <c:forEach begin="1" end="${sessionScope.listSize}" step="1" var="size">
                        <li><a href="javascript:;" data-page="${size}" id="page${size}" name="${size}">${size}</a></li>
                    </c:forEach>
                    <%--<li>--%>
                        <%--<a href="#" aria-label="Next">--%>
                            <%--<span aria-hidden="true">&raquo;</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                </ul>
            </nav>

            <%--模态框--%>
            <div class="modal fade" id="modal-container-stu-info" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                考生信息
                            </h4>
                        </div>
                        <div class="modal-body">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var DATALIST = <%=session.getAttribute("json")%>;
    var NUMBER = <%=session.getAttribute("size")%>;
</script>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/my_js.js"></script>
</body>
</html>