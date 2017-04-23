package test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "UpdateJsonDataServlet", urlPatterns = {"/UpdateJsonDataServlet"})
public class UpdateJsonDataServlet extends HttpServlet {
    /**
     * 接收报考信息
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String str = req.getParameter("updateData");
        str = new String(str.getBytes("ISO8859-1"), "UTF-8");

        JsonObject jsonObject = null;
        String name = "";
        String jsonKey = "";
        String jsonValue = "";
        if (!str.isEmpty()) {
            jsonObject = new JsonParser().parse(str).getAsJsonObject();
            name = jsonObject.get("name").getAsString();
            jsonKey = jsonObject.get("infoName").getAsString();
            jsonValue = jsonObject.get("info").getAsString();
        }
        System.out.print(str);
        System.out.print(name);

        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            con = DriverManager.getConnection(url, "root", "root");
            sm = con.createStatement();
            sm.executeUpdate("UPDATE stu_all_info SET stu_info = " +
                    "JSON_REPLACE(stu_info, '$." + jsonKey + "','" + jsonValue + "'" + ") " +
                    "WHERE stu_name = '" + name + "'");

            resp.getWriter().write("");
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
