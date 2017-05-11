<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="Util.DbUtil" %>
<%@ page import="com.google.gson.JsonParser" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dim
  Date: 2017/4/26
  Time: 15:10
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
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12">
            <%
                Connection con = null;
                Statement sm = null;
                ResultSet rs = null;
                JsonObject jsonObject = new JsonObject();
                String[] infos = {"姓名", "证件类型", "证件号码", "民族", "性别", "婚否", "现役军人", "政治面貌",
                        "籍贯所在地", "出生地", "户口所在地", "户口所在地详细地址", "考生档案所在地", "考生档案所在单位地址",
                        "考生档案所在单位邮政编码", "现在学习或工作单位", "学习与工作经历", "何时何地何原因受过何种奖励或处分",
                        "考生作弊情况", "家庭主要成员", "考生通讯地址", "考生通讯地址邮政编码", "固定电话", "移动电话",
                        "电子邮箱", "考生来源", "毕业学校", "毕业专业", "取得最后学历的学习形式", "最后学历", "毕业证书编号",
                        "获得最后学历毕业年月", "注册学号", "最后学位", "学位证书编号", "报考单位", "报考专业", "考试方式",
                        "专项计划", "报考类别", "定向就业单位所在地", "定向就业单位", "报考院系", "研究方向", "政治理论", "外国语",
                        "业务课一", "业务课二", "备用信息一", "备用信息二"};
                try {
                    con = DbUtil.getConn();
                    sm = con.createStatement();
                    rs = sm.executeQuery("SELECT * FROM stu_all_info");
                    if (rs.next()) {
                        int i = 0;
                        jsonObject = new JsonParser().parse(rs.getString("stu_info")).getAsJsonObject();
                        Iterator iterator = jsonObject.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry entry = (Map.Entry) iterator.next();
                            out.print("<p class='lead'>" + infos[i] + ":</p><input class='form-control' value='" + entry.getValue() + "'><br/>");
                            i++;
                        }
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
            <button class="btn btn-primary" id="btnStuModifyCommit">提交修改</button>
            <button class="btn btn-default">取消</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="./js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/my_js.js"></script>
</body>
</html>
