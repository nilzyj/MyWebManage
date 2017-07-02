package Stu;

import Util.DbUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "UpdateJsonDataServlet", urlPatterns = {"/UpdateJsonDataServlet"})
public class UpdateJsonDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("**************Android修改报考信息**************");
        String str = req.getParameter("updateData");
        str = new String(str.getBytes("ISO8859-1"), "UTF-8");

        JsonObject jsonObject = null;
        String username = "";
        String jsonKey = "";
        String jsonValue = "";
        if (!str.isEmpty()) {
            jsonObject = new JsonParser().parse(str).getAsJsonObject();
            username = jsonObject.get("username").getAsString();
            jsonKey = jsonObject.get("infoName").getAsString();
            jsonValue = jsonObject.get("info").getAsString();
        }
        System.out.print(str);
        System.out.print(username);

        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            sm.executeUpdate("UPDATE stu_all_info SET stu_info = " +
                    "JSON_REPLACE(stu_info, '$." + jsonKey + "','" + jsonValue + "')" +
                    "WHERE stu_username = '" + username + "'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
        resp.getWriter().write("success");
        System.out.println("**************Android修改报考信息**************");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
