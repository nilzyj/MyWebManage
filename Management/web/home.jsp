<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/my_css.css">
    <script src="./js/jquery-3.1.1.js"></script>
    <script src="./js/bootstrap.min.js"></script>
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
                <%--顶部导航栏--%>
                <div class="navbar-header">
                    <a class="navbar-brand" href="home.jsp">网页管理端</a>
                </div>
                <div>
                    <%--nav-justfied两端对齐--%>
                    <ul class="nav nav-tabs nav-justified">
                        <li class="dropdown">
                            <a href="#panel-1" data-toggle="tab" id="exam_info">考试信息 </a>
                        </li>
                        <li>
                            <a href="#panel-2" data-toggle="tab" id="stu_info">考生信息</a>
                        </li>
                        <li>
                            <a href="#panel-3" data-toggle="tab" id="finger_info">指纹信息</a>
                        </li>
                        <li>
                            <a href="#panel-4" data-toggle="tab" id="illgel_action">违规行为</a>
                        </li>
                        <li>
                            <a href="#panel-5" data-toggle="tab" id="grade">考试成绩管理</a>
                        </li>
                        <li>
                            <a href="#panel-6" data-toggle="tab" id="account">帐号管理</a>
                        </li>
                    </ul>
                </div>
                <%--/顶部导航栏--%>
                <%--导航栏内容--%>
                <div class="col-md-12 column">
                    <div class="tab-content">
                        <div class="tab-pane active" id="panel-1">
                            <div class="col-md-10 column">
                                报名时间：2016.9.24-2017.11</br>
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
                        </div>
                        <div class="tab-pane" id="panel-11">
                            考生安排
                        </div>
                        <div class="tab-pane" id="panel-12">
                            监考教师安排
                        </div>
                        <div class="tab-pane" id="panel-2">
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
                        </div>
                        <div class="tab-pane" id="panel-3">
                            <p>
                                指纹信息管理
                            </p>
                        </div>
                        <div class="tab-pane" id="panel-4">
                            <p>
                                违规行为：姓名，时间，地点，方式
                            </p>
                        </div>
                        <div class="tab-pane" id="panel-5">
                            <p>
                                考试成绩管理
                            </p>
                        </div>
                        <div class="tab-pane" id="panel-6">
                            <p>
                                密码修改，
                            </p>
                        </div>
                    </div>
                    <%--导航栏内容--%>
                </div>
            </div>
        </div>
    </div>
    <%--底部导航--%>
    <div class="row clearfix">

    </div>
    <%--/底部导航--%>
</div>
</body>
</html>
