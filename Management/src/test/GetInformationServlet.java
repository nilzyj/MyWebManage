package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dim on 2017/4/11.
 */
@WebServlet(name = "GetInformationServlet", urlPatterns = "/GetInformationServlet")
public class GetInformationServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String data = "";

        Connection con = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/mydb";
            con = DriverManager.getConnection(url,"root","root");
            sm = con.createStatement();
            rs = sm.executeQuery("SELECT stu_info WHERE stu_name =" + name);
            if(rs.next()) {
                resp.getWriter().write(data);
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
