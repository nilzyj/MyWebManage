package Stu;

import Util.DbUtil;

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
import java.util.Calendar;

/**
 * Created by dim on 2017/4/11.
 */
@WebServlet(name = "GetInformationServlet", urlPatterns = "/GetInformationServlet")
public class GetInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("**************Android获取报考信息**************");
        String username = req.getParameter("username");
        String flag = req.getParameter("flag");
        System.out.println(flag);
        System.out.println(username);
        username = new String(username.getBytes("ISO8859-1"), "UTF-8");
        String state = "";
        Calendar calendar = Calendar.getInstance();
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            if (!"leadingin".equals(flag)) {
                rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_username ='" + username + "'"
                        + " AND stu_year='" + calendar.get(Calendar.YEAR) + "'");
                if (rs.next()) {
                    if (rs.getString("stu_info") != null) {
                        state = rs.getString("stu_info");
                    } else {
                        state = "未填写报考信息";
                    }
                }
            } else {
                rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_username ='" + username + "'"
                        + " AND stu_year!='" + calendar.get(Calendar.YEAR)+ "'");
                if (rs.next()) {
                    if (rs.getString("stu_info") != null) {
                        state = rs.getString("stu_info");
                        System.out.println("返回导入所需信息：" + state);
                    } else {
                        state = "无可导入报考信息";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }

        state = URLEncoder.encode(state, "UTF-8");
        resp.getWriter().

                print(state);
        System.out.println("**************Android获取报考信息**************");
    }
}
