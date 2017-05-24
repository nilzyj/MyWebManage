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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes("ISO8859-1"), "UTF-8");

        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_name ='" + name + "'");
            if (rs.next()) {
                if (rs.getString("stu_info") != null) {
                    String state = rs.getString("stu_info");
                    state = URLEncoder.encode(state, "UTF-8");
                    resp.getWriter().print(state);
                } else {
                    resp.getWriter().print("未填写报考信息");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
    }
}
