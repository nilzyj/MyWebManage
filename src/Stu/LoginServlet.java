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
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //android
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String jsonData = req.getParameter("loginData");
        jsonData = new String(jsonData.getBytes("ISO8859-1"), "UTF-8");

        JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        String password = jsonObject.get("password").getAsString();

        System.out.print(name);

        String state = "Database Error!";
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            rs = sm.executeQuery("select * from stu_account where stu_name='" + name + "'");
            if (rs.next()) {
                if (rs.getString("stu_password").equals(password)) {
                    rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_name='" + name + "'");
                    if(rs.next()) {
                        if (rs.getString("stu_info") == null) {
                            state = "1";//密码正确，未填写信息
                        } else {
                            state = "2";//密码正确，已填写信息
                        }
                    }
                } else {
                    state = "3";//密码错误
                }
            } else {
                state = "0";//用户不存在
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
        state = URLEncoder.encode(state, "UTF-8");
        resp.getWriter().print(state);
//        resp.getWriter().print(URLEncoder.encode("中文", "UTF-8"));

//        resp.getWriter().print(URLEncoder.encode(jsonData,"UTF-8"));
    }
}
