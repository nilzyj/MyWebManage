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
    <style type="text/css">
        .clearfix {
            clear: both;
        }
        .clearfix:after {
            clear: both;
            content: "";
            display: block;
            height: 0;
            visibility: hidden;
        }
        .fl {
            float: left;
        }
        .fr {
            float: right;
        }
        .pager {
            max-width: 800px;
            text-align: center;
            margin-bottom: 30px;
            display: inline-block;
        }
        .pager a{
            cursor: pointer;
        }
        .pager a,
        .pager span {
            width: 29px;
            height: 28px;
            border: 1px #cccccc solid;
            margin-left: -1px;
            color: #8a8a8a;
            display: inline-block;
            line-height: 28px;
            float: left;
            font-size: 12px;
            text-decoration: none;
            margin: 0 2px;
        }
        .pager a:hover,
        .pager span:hover {
            border-color: #3897cd;
            color: #3897cd;
            position: relative;
            z-index: 1;
        }
        .pager span.current {
            background-color: #3897cd;
            color: #fff;
            border-color: #3897cd;
            position: relative;
            z-index: 1;
        }
        .pager .pg-first,
        .pager .pg-prev,
        .pager .pg-next,
        .pager .pg-last{
            background: url(images/page_bg.jpg) 0 0 no-repeat;
        }
        .pager .pg-first:hover,
        .pager .pg-prev:hover,
        .pager .pg-next:hover,
        .pager .pg-last:hover{
            background: url(images/page_bg_hover.jpg) 0 0 no-repeat;
        }
        .pager .pg-prev,
        .pager .pg-prev:hover{
            background-position: 0 -28px;
        }
        .pager .pg-next,
        .pager .pg-next:hover{
            background-position: -29px -28px;
        }
        .pager .pg-last,
        .pager .pg-last:hover{
            background-position: -29px 0;
        }
        .pager .pg-prev[disabled='true'],
        .pager .pg-prev[disabled='true']:hover{
            cursor: default;
            background-image: url(images/page_bg.jpg);
        }
        .pager .pg-next[disabled='true'],
        .pager .pg-next[disabled='true']:hover{
            cursor: default;
            background-image: url(images/page_bg.jpg);
        }
        .pager .pg-prev[disabled='true'],
        .pager .pg-next[disabled='true']{
            border-color: #eeeeee;
        }
        .pager span.els{
            border-color: transparent;
        }

        .pagerHtmlWrap{
            width: 800px;
            margin: 30px auto;
        }
        .pagerHtmlWrap .cc_cells{
            width: 100%;
            height: 35px;
            padding: 5px 0;
            border-bottom: 1px #cccccc solid;
        }
        .pagerHtmlWrap .cc_cells a{
            color: #454545;
            font-size: 14px;
            line-height: 35px;
            text-decoration: none;
        }
        .pagerHtmlWrap .cc_cells a span{
            display: inline-block;
            width: 25%;
            text-align: left;
            margin: 0;
        }
    </style>
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
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="student_info_tbody">
                <c:forEach begin="0" end="19" step="1" items="${sessionScope.studentList}" var="info">
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

            <%--<div style="text-align: center;margin:20px auto;"><div id="pager" class="pager clearfix"></div></div>--%>

            <%--<div id="wraper" class="pagerHtmlWrap"></div>--%>

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
<script type="text/javascript" src="js/jquery.z-pager.js" charset="utf-8"></script>
<script type="text/javascript" src="js/my_js.js"></script>
<script type="text/javascript">
    $("#pager").zPager({
        totalData: 60,
        dataRender: function(data){
            var self = this;
            var _html = '拼接的字符串';
            self.htmlBox.html(_html);
            //ajax获取每页data数据后，可用此方法生成数据列表
            //此方法有默认function，也可以不写 具体参考demo
            console.log(data+'---ajax获取到的json格式的data数据');
        }
    });
    $("#pager2").zPager({
        url:'pageData.json',
        htmlBox: $('#wraper'),
        btnShow: false
    });
</script>
</body>
</html>