package test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dim on 2017/4/22.
 */
@WebServlet(name = "ModifyPasswordServlet", urlPatterns = {"/ModifyPasswordServlet"})
public class ModifyPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modifyData = req.getParameter("modifyData");
        modifyData = new String(modifyData.getBytes("ISO8859-1"), "UTF-8");
        JsonObject jsonObject = new JsonParser().parse(modifyData).getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        String oldPassword = jsonObject.get("oldPassword").getAsString();
        String newPassword = jsonObject.get("newPassword").getAsString();
        System.out.print(oldPassword + newPassword + name);
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            con = DriverManager.getConnection(url, "root", "root");
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_account WHERE stu_name = '" + name + "'");
            if (rs.next()) {
                if (oldPassword.equals(rs.getString("stu_password"))) {
                    sm.executeUpdate("UPDATE stu_account SET stu_password = '" +
                            newPassword + "' WHERE stu_name = '" + name + "'");
                    resp.getWriter().print(URLEncoder.encode("1", "UTF-8"));//修改密码成功
                } else {
                    resp.getWriter().print(URLEncoder.encode("2", "UTF-8"));//密码错误
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (sm != null) {
                try {
                    sm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
