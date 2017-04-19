package test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//        req.setCharacterEncoding("UTF-8");
        JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        String password = jsonObject.get("password").getAsString();

        String state = "database error!";
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/mydb";
            con = DriverManager.getConnection(url, "root", "root");
            sm = con.createStatement();
            rs = sm.executeQuery("select * from stu_account where stu_name='" + name + "'");
            if (rs.next()) {
                if (rs.getString("stu_password").equals(password)) {
                    rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_name='" + name + "'");
                    if(rs.next()) {
                        if (rs.getString("stu_info") == null) {
                            state = "1";//密码正确，未填写信息
                        } else {
                            state = "2";//密码正确，填写了信息
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
        resp.getWriter().print(state);
    }
}
