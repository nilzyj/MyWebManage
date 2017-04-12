<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/my_css.css">
    <script src="js/jquery-3.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<%--布局容器--%>
<%--栅格系统用于通过一系列的行（row）与列（column）的组合来创建页面布局--%>
<%--流式布局容器container-fluid将固定宽度的栅格布局转换为 100% 宽度的布局。--%>
<div class="container">
    <%--行--%>
    <div class="row clearfix">
        <%--类前缀.col-md-:中等屏幕，桌面显示器--%>
        <div class="col-md-12 column">
            <div class="tabbable" id="tabs-159844">
                    <%--导航栏--%>
                <div class="navbar-header">
                    <a class="navbar-brand" href="home.jsp">网页管理端</a>
                </div>
                <div>
                    <ul class="nav nav-tabs">
                        <li>
                            <a href="#panel-584456" data-toggle="tab">考试信息</a>
                            <%--<li><a href="#">考试地点，时间安排</a></li>--%>
                            <%--<li><a href="#">考生安排</a></li>--%>
                            <%--<li><a href="#">监考教师安排</a></li>--%>
                        </li>
                        <li>
                            <a href="#panel-99387" data-toggle="tab">考生信息</a>
                        </li>
                        <li>
                            <a href="#panel-135235" data-toggle="tab">指纹信息</a>
                        </li>
                        <li>
                            <a href="#panel-123523" data-toggle="tab">违规行为</a>
                        </li>
                        <li>
                            <a href="#panel-892347" data-toggle="tab">帐号管理</a>
                        </li>
                    </ul>
                </div>
                    <%--/导航栏--%>
                    <%--左侧内容--%>
                <div class="col-md-2 column" style="margin-top: 10px">
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">SVN</a></li>
                        <li><a href="#">iOS</a></li>
                        <li><a href="#">VB.Net</a></li>
                        <li><a href="#">Java</a></li>
                        <li><a href="#">PHP</a></li>
                    </ul>
                </div>
                    <%--/左侧内容--%>
                    <%--右侧内容--%>
                <div class="col-md-10 column">
                    <div class="tab-content">
                        <div class="tab-pane active" id="panel-584456">
                            报名时间：2016.9.24-2017.11</br>
                            考试地点、时间。考生。监考教师。
                            <table class="table table-bordered">
                                <%--<caption>基本的表格布局</caption>--%>
                                <thead>
                                <tr>
                                    <th>科目</th>
                                    <th>考试时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>数学</td>
                                    <td>2016.12.24 9:00 a.m</td>
                                </tr>
                                <tr>
                                    <td>英语</td>
                                    <td>2016.12.24 3:00 p.m</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane" id="panel-99387">
                            姓名：<input class="input-type" type="text" name="name"></br>
                            性别：<input class="input-type" type="text" name="name"></br>
                            年龄：<input class="input-type" type="text" name="name"></br>
                            民族：<input class="input-type" type="text" name="name"></br>
                            出生地：<input class="input-type" type="text" name="name"></br>
                            电话：<input class="input-type" type="text" name="name"></br>
                            毕业学校：<input class="input-type" type="text" name="name"></br>
                            考试方式：<input class="input-type" type="text" name="name"></br>
                            研究方向：<input class="input-type" type="text" name="name"></br>
                            <button class="btn btn-default">确定</button>
                            <p>

                            </p>
                        </div>
                        <div class="tab-pane" id="panel-135235">
                            <p>
                                指纹信息管理
                            </p>
                        </div>
                        <div class="tab-pane" id="panel-123523">
                            <p>
                                违规行为：姓名，时间，地点，方式
                            </p>
                        </div>
                        <div class="tab-pane" id="panel-892347">
                            <p>
                                密码修改，
                            </p>
                        </div>
                    </div>
                </div>
                    <%--右侧内容--%>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class=""></div>
    </div>
</div>
</body>
</html>
