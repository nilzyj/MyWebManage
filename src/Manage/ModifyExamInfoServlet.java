package Manage;

import Util.PinYinUtil;
import Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dim on 2017/4/24.
 */
@WebServlet(name = "ModifyExamInfoServlet", urlPatterns = {"/ModifyExamInfoServlet"})
public class ModifyExamInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examAddr = request.getParameter("examAddr");
        String examTime = request.getParameter("examTime");
        String examName = request.getParameter("examName");
//        examAddr = new String(examAddr.getBytes("iso8859-1"), "UTF-8");
//        examTime = new String(examTime.getBytes("iso8859-1"), "UTF-8");
//        examName = new String(examName.getBytes("iso8859-1"), "UTF-8");

        System.out.println(examAddr);
        System.out.println(examTime);
        System.out.println(examName);
        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        PinYinUtil pyu = new PinYinUtil();
        try {
            con = DbUtil.getConn();
            sm = con.createStatement();
            sm.executeUpdate("UPDATE manage_info SET exam_time = '" + examTime + "',exam_address = '" +
                    examAddr + "' WHERE exam_name = '" + examName + "'");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
