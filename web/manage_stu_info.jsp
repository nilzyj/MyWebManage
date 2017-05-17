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
            <form class="form-inline navbar-left" style="margin-top: 10px" action="SearchStudentServlet" method="get">
                <div class="form-group">
                    <input type="text" class="form-control" id="searchName" placeholder="张三">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="searchbaokaodian" placeholder="张三@example.com">
                </div>
                <div class="form-group">
                    <input type="number" class="form-control" id="searchbaokaohao" placeholder="111110001">
                </div>
                <button id="searchBtn" type="button" class="btn btn-default btn-primary">查询</button>
                <button id="clearBtn" type="button" class="btn btn-default btn-primary">清除</button>
            </form>

            <%--显示考生信息--%>
            <table class="table table-bordered table-hover table-condensed" style="margin-top: 2cm;">
                <thead>
                <tr>
                    <th>考生序号</th>
                    <th>考生姓名</th>
                    <th>报考点</th>
                    <th>报考号</th>
                    <th>考生具体信息</th>
                    <th>信息操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.list}" var="info">
                    <tr>
                        <td><c:out value="${info.ID}" /></td>
                        <td><c:out value="${info.name}" /></td>
                        <td>报考点</td>
                        <td>报考号</td>
                        <td><a href='stu_info.jsp' role='button' class='btn'>查看</a></td>
                        <td><a href='stu_info_modify.jsp' role='button' class='btn'>修改</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <%--考生信息查看弹出框--%>
            <div class="modal fade" id="modal-container-325222" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabelStuInfo">
                                全部考生信息
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

            <%--遮罩窗体，弹出的修改框--%>
            <div class="modal fade" id="modal-container-325223" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabelExam">
                                考生信息修改
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="ModifyExamInfoServlet">
                                <div class="form-group">
                                    <label for="examAddr">考生信息</label>
                                    <input type="text" class="form-control" id="examAddr" placeholder="考生信息">
                                </div>
                                <div class="form-group">
                                    <label for="examTime">考生信息</label>
                                    <input type="text" class="form-control" id="examTime" placeholder="考生信息">
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
</div>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/my_js.js"></script>
</body>
</html>
