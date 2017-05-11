<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Util.DbUtil" %><%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/26
  Time: 8:34
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
        <form method="post" action="ModifyExamInfoServlet">
            <div class="form-group">
                <label for="oldPwd">旧密码</label>
                <input type="text" class="form-control" id="oldPwd" placeholder="旧密码">
            </div>
            <div class="form-group">
                <label for="newOld">新密码</label>
                <input type="text" class="form-control" id="newOld" placeholder="新密码">
            </div>
            <div class="form-group">
                <label for="newOldRepeat">重复新密码</label>
                <input type="text" class="form-control" id="newOldRepeat" placeholder="重复新密码">
            </div>
            <%--<button type="submit" class="btn btn-default">Submit</button>--%>
        </form>
        <%--<table class="table table-bordered table-hover table-condensed" style="margin-top: 2cm;">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th>考试名称</th>--%>
                <%--<th>考试时间</th>--%>
                <%--<th>监考安排</th>--%>
                <%--<th>操作</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<%--%>
                <%--Connection con = null;--%>
                <%--Statement sm = null;--%>
                <%--ResultSet rs = null;--%>
                    <%--PinYinUtil pyu = new PinYinUtil();--%>
                <%--try {--%>
                    <%--con = DbUtil.getConn();--%>
                    <%--sm = con.createStatement();--%>
                    <%--rs = sm.executeQuery("SELECT * FROM proctor_info");--%>
                    <%--while (rs.next()) {--%>
                        <%--out.print("<tr>");--%>
                        <%--out.print("<td>" + rs.getString("proctor_name") + "</td>");--%>
                        <%--out.print("<td>" + rs.getInt("proctor_exam") + "</td>");--%>
                        <%--out.print("<td>安排</td>");--%>
                        <%--out.print("<td><a id='" + //pyu.getStringPinYin(rs.getString("exam_name")) +--%>
                                <%--"' href='#modal-container-325223' role='button' class='btn' data-toggle='modal'>" +--%>
                                <%--"修改</a></td>");--%>
                        <%--out.print("<tr>");--%>
                    <%--}--%>
                    <%--con.close();--%>
                    <%--sm.close();--%>
                    <%--rs.close();--%>
                <%--} catch (Exception e) {--%>
                    <%--e.printStackTrace();--%>
                <%--} finally {--%>
                    <%--DbUtil.dbClose(con, sm, rs);--%>
                <%--}--%>
            <%--%>--%>
            <%--</tbody>--%>
        <%--</table>--%>


    </div>
</div>
<script type="text/javascript" src="./js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/my_js.js"></script>
</body>
</html>
