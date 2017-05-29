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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //android登录
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************Android登录**************");
        String jsonData = request.getParameter("loginData");
        jsonData = new String(jsonData.getBytes("ISO8859-1"), "UTF-8");

        JsonObject jsonObject = new JsonParser().parse(jsonData).getAsJsonObject();
        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();

        System.out.println("登录用户名：" + username);
        System.out.println("登录密码：" + password);

        String name = "";
        String stu_id = "";
        String stu_id_type = "";

        String state = "";
        JsonObject data = new JsonObject();
        Calendar calendar = Calendar.getInstance();
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        String systemState = "";
        try {
            Connection con1 = DbUtil.getConn();
            Statement sm1 = con1.createStatement();
            ResultSet rs1 = sm1.executeQuery("SELECT * FROM system_on_off");
            if (rs1.next()) {
                if (rs1.getInt("systemState") == 1) {
                    systemState = "1";
                } else {
                    systemState = "0";
                }
            }
            DbUtil.dbClose(con1, sm1, rs1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            // 验证密码
            rs = sm.executeQuery("select * from stu_account where stu_username='" + username + "'");
            if (rs.next()) {
                if (rs.getString("stu_password").equals(password)) {
                    //密码正确则获取相关数据
                    name = rs.getString("stu_name");
                    stu_id = rs.getString("stu_id");
                    stu_id_type = rs.getString("stu_id_type");
                    rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_username='" + username + "'"
                            + " AND stu_year='" + calendar.get(Calendar.YEAR) + "'");
                    if (rs.next()) {
                        data.addProperty("name", name);
                        data.addProperty("stu_id", stu_id);
                        data.addProperty("stu_id_type", stu_id_type);
                        if (rs.getInt("stu_isfill") == 0) {
                            data.addProperty("state", "1");//密码正确，未填写信息
                        } else {
                            data.addProperty("state", "2");//密码正确，已填写信息
                        }
                    }
                } else {
                    data.addProperty("name", "");
                    data.addProperty("stu_id", "");
                    data.addProperty("stu_id_type", "");
                    data.addProperty("state", "3");//密码错误
                }
            } else {
                data.addProperty("name", "");
                data.addProperty("stu_id", "");
                data.addProperty("stu_id_type", "");
                data.addProperty("state", "3");//用户不存在
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }

        data.addProperty("systemState", systemState);
        System.out.println("data：" + data);
        state = data.toString();
        System.out.println("登录服务器返回:" + state);
        state = URLEncoder.encode(state, "UTF-8");

        response.getWriter().print(state);
        System.out.println("**************Android登录**************");
    }
}
