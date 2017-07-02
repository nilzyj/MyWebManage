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
 * Created by dim on 2017/5/30.
 */
@WebServlet(name = "ConfirmServlet", urlPatterns = {"/ConfirmServlet"})
public class ConfirmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************Android确认报考信息**************");
        String username = request.getParameter("username");
        System.out.println("request:" + username);
        String state = "";
        username = new String(username.getBytes("ISO8859-1"), "UTF-8");
        System.out.println(username);

        Connection con = DbUtil.getConn();
        Statement sm = null;
        ResultSet rs = null;

        try {
            sm = con.createStatement();
            sm.executeUpdate("UPDATE stu_all_info SET stu_confirm = 1 WHERE stu_username='" + username + "'");
            state = "success";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }

        response.getWriter().print(state);
        System.out.println("**************Android确认报考信息**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
