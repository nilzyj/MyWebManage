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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************Android获取报考号**************");
        String baokaodian = request.getParameter("baokaodian");
        String baokaohao = "";
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_all_info ORDER BY id_stu_all_info DESC LIMIT 1");
            while (rs.next()) {
                if (rs.getInt("stu_baokaohao") != 0) {
                    System.out.println("最大报考号：" + rs.getInt("stu_baokaohao"));
                    baokaohao = rs.getInt("id_stu_all_info") + 1 + "";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.getWriter().print(baokaohao);
        System.out.println("**************Android获取报考号**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
