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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        name = new String(name.getBytes("ISO8859-1"), "UTF-8");

        Connection con = DbUtil.getConn();
        Statement sm = null;
        ResultSet rs = null;

        try {
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_name ='" + name + "'");
            if (rs.next()) {
                String state = rs.getString("stu_photo");
                System.out.println(state);
                response.getWriter().print(state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
