<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Util.DbUtil" %><%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/24
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/my_css.css">
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered table-hover table-condensed" style="margin-top: 2cm;">
                <thead>
                <tr>
                    <th>考生序号</th>
                    <th>考生姓名</th>
                    <th>考生信息</th>
                    <th>信息操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Connection con = null;
                    Statement sm = null;
                    ResultSet rs = null;
//                    PinYinUtil pyu = new PinYinUtil();
                    try {
                        con = DbUtil.getConn();
                        sm = con.createStatement();
                        rs = sm.executeQuery("SELECT * FROM stu_all_info");
                        while (rs.next()) {
                            out.print("<tr>");
                            out.print("<td>" + rs.getInt("idstu_all_info") + "</td>");
                            out.print("<td>" + rs.getString("stu_name") + "</td>");
                            out.print("<td><a id='" + //pyu.getStringPinYin(rs.getString("exam_name")) +
                                    "' href='stu_info.jsp' role='button' class='btn'>" +
                                    "查看</a></td>");
                            out.print("<td><a id='" + //pyu.getStringPinYin(rs.getString("exam_name")) +
                                    "' href='stu_info_modify.jsp' role='button' class='btn'>" +
                                    "修改</a></td>");
                            out.print("<tr>");
                        }
                        con.close();
                        sm.close();
                        rs.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        DbUtil.dbClose(con, sm, rs);
                    }
                %>
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
<script type="text/javascript" src="./js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/x-markdown" src="./js/my_js.js"></script>
</body>
</html>
