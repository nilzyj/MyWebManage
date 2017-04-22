package test;

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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dim on 2017/4/18.
 */
@WebServlet(name = "ExamInfoServlet", urlPatterns = {"/ExamInfoServlet"})
public class ExamInfoServlet extends HttpServlet {
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
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            con = DriverManager.getConnection(url,"root","root");
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_name ='" + name + "'");
            if(rs.next()) {
                String state = rs.getString("stu_exam_info");
                state = URLEncoder.encode(state, "UTF-8");
                resp.getWriter().write(state);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(rs != null) {
                try{rs.close();}catch(Exception e){e.printStackTrace();}
            }
            if(sm != null) {
                try{sm.close();}catch(Exception e){e.printStackTrace();}
            }
            if(con != null) {
                try{con.close();}catch(Exception e){e.printStackTrace();}
            }
        }
    }
}
