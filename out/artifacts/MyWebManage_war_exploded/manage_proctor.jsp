<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Util.DbUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/my_css.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>首页</title>
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table id="table" class="table table-bordered table-hover table-condensed" style="margin-top: 2cm;">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>监考教师姓名</th>
                    <th>监考安排</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="proctor_tbody">
                <%
                    Connection con = null;
                    Statement sm = null;
                    ResultSet rs = null;
                    try {
                        con = DbUtil.getConn();
                        sm = con.createStatement();
                        rs = sm.executeQuery("SELECT * FROM proctor_info");
                        while (rs.next()) {
                            out.print("<tr>");
                            out.print("<td>" + rs.getInt("idproctor_info") + "</td>");
                            out.print("<td>" + rs.getString("proctor_name") + "</td>");
                            out.print("<td>" + rs.getInt("proctor_exam") + "</td>");
                            out.print("<td><a href='#modal-container-325224' role='button' class='btn' data-toggle='modal'>" +
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

            <%--遮罩窗体，弹出的修改框--%>
            <div class="modal fade" id="modal-container-325224" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                监考信息修改
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="">
                                <div class="form-group">
                                    <label for="proctorName">监考教师</label>
                                    <input type="text" class="form-control" id="proctorName" placeholder="教师姓名">
                                </div>
                                <div class="form-group">
                                    <label for="examInfo">考试安排</label>
                                    <input type="text" class="form-control" id="examInfo" placeholder="考试地点时间">
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
