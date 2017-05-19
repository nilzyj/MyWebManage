<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/26
  Time: 8:33
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
        <p>添加记录、修改记录、删除记录、设置是否能参加考试</p>
        <p class="lead" style="margin-top: 10px;margin-bottom: 0px">考生违规信息列表</p>
        <%--考生查询--%>
        <form class="form-inline navbar-left" style="margin-top: 10px">

            <div class="form-group">
                <input type="number" class="form-control" id="searchYear" placeholder="违规年份：2000">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="searchName" placeholder="违规考生姓名：张三">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" id="searchbaokaodian" placeholder="违规行为">
            </div>
            <button id="searchBtn" type="button" class="btn btn-default btn-primary">查询</button>
            <button id="clearBtn" type="button" class="btn btn-default btn-primary">清除</button>
                <a href="#modal-container-invalid-add" class="btn btn-default btn-primary" data-toggle="modal">添加</a>
            <c:out value="${sessionScope.searchResult}"/>
        </form>

        <table id="table" class="table table-bordered table-hover table-condensed" style="margin-top: 10px">
            <thead>
            <tr>
                <th>序号</th>
                <th>违规时间</th>
                <th>违规者姓名</th>
                <th>违规行为</th>
                <th>是否能参加考试</th>
                <%--<th>操作</th>--%>
            </tr>
            </thead>
            <tbody id="invalid_tbody">
            <c:forEach items="${sessionScope.invalidActionList}" var="invalidAction">
                <tr>
                    <td><c:out value="${invalidAction.ID}"/></td>
                    <td><c:out value="${invalidAction.year}"/></td>
                    <td><c:out value="${invalidAction.name}"/></td>
                    <td><c:out value="${invalidAction.invalidAction}"/></td>
                    <td>
                        <label class="radio-inline">
                            <input type="radio" name="optionsRadios<c:out value='${invalidAction.ID}'/>"
                                   class="radio optionsRadios1" value="option1"
                            <c:if test="${invalidAction.ifCanExam == 1}">
                                <c:out value="checked"/>
                            </c:if>
                            >能
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="optionsRadios<c:out value='${invalidAction.ID}'/>"
                                   class="radio optionsRadios2" value="option2"
                            <c:if test="${invalidAction.ifCanExam == 0}">
                                <c:out value="checked"/>
                            </c:if>
                            >不能
                        </label>
                    </td>

                    <%--<td><c:out value="${invalidAction.ifCanExam}"/> </td>--%>
                    <%--<td><a role="button" class="btn">删除</a>--%>
                        <%--<a href="#modal-container-invalid-modify" role="button" class="btn invalid_modify"--%>
                           <%--data-toggle="modal">修改</a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <%--遮罩窗体，弹出的添加框--%>
        <div class="modal fade" id="modal-container-invalid-add" role="dialog" aria-labelledby="添加违规信息"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                            添加违规信息
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="ModifyExamInfoServlet">
                            <div class="form-group">
                                <label for="invalid_action_name_add">违规考生姓名</label>
                                <input type="text" class="form-control" id="invalid_action_name_add" placeholder="姓名">
                            </div>
                            <div class="form-group">
                                <label for="invalid_action_add">违规行为</label>
                                <input type="text" class="form-control" id="invalid_action_add" placeholder="违规行为">
                            </div>
                            <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button id="invalid_action_add_submit" type="button" class="btn btn-primary" >确定</button>
                    </div>
                </div>
            </div>
        </div>

        <%--遮罩窗体，弹出的修改框--%>
        <%--<div class="modal fade" id="modal-container-invalid-modify" role="dialog" aria-labelledby="修改违规信息"--%>
             <%--aria-hidden="true">--%>
            <%--<div class="modal-dialog">--%>
                <%--<div class="modal-content">--%>
                    <%--<div class="modal-header">--%>
                        <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>--%>
                        <%--<h4 class="modal-title" id="invalid_title">--%>
                            <%--考生违规信息修改--%>
                        <%--</h4--%>
                    <%--</div>--%>
                    <%--<div class="modal-body">--%>
                        <%--<form method="post" action="ModifyExamInfoServlet">--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="invalid_action">违规行为</label>--%>
                                <%--<input type="text" class="form-control" id="invalid_action" placeholder="违规行为">--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="invalid_if_can_exam">是否能参加考试</label>--%>
                                <%--<input type="text" class="form-control" id="invalid_if_can_exam" placeholder="是/否">--%>
                            <%--</div>--%>
                            <%--&lt;%&ndash;<button type="submit" class="btn btn-default">Submit</button>&ndash;%&gt;--%>
                        <%--</form>--%>
                    <%--</div>--%>
                    <%--<div class="modal-footer">--%>
                        <%--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                        <%--<button id="btnModifyInvalidAction" type="button" class="btn btn-primary" >确定</button>--%>
                    <%--</div>--%>

                <%--</div>--%>

            <%--</div>--%>

        <%--</div>--%>
    </div>
</div>
</div>
<script type="text/javascript" src="./js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/my_js.js"></script>
</body>
</html>
