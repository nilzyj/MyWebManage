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
 * Created by dim on 2017/5/15.
 */
@WebServlet(name = "baokaohaoServlet", urlPatterns = {"/baokaohaoServlet"})
public class baokaohaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String baokaodian = request.getParameter("baokaodian");

        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_all_info ORDER BY idstu_all_info LIMIT 1");
            if (rs.next()) {
                String baokaohao = rs.getInt("idstu_all_info") + 1 + "";
                response.getWriter().print(baokaohao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
