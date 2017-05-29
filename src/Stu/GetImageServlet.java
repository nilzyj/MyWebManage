package Stu;

import Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dim on 2017/5/24.
 */
@WebServlet(name = "GetImageServlet", urlPatterns = {"/GetImageServlet"})
public class GetImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************Android获取图片**************");
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO8859-1"), "UTF-8");
        String state = "";
        Connection con = DbUtil.getConn();
        Statement sm = null;
        ResultSet rs = null;

        try {
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_username ='" + username + "'");
            if (rs.next()) {
                state = rs.getString("stu_photo");
                System.out.println(state);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
        response.getWriter().print(state);
        System.out.println("**************Android获取图片**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
