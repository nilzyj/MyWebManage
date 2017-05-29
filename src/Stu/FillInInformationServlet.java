package Stu;

import Util.DbUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

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
import java.util.Calendar;

@WebServlet(name = "FillInInformationServlet", urlPatterns = {"/FillInInformationServlet"})
public class FillInInformationServlet extends HttpServlet {
    /**
     * 接收报考信息
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("**************Android提交报考信息**************");
        String str = req.getParameter("fillData");
        str = new String(str.getBytes("iso8859-1"), "UTF-8");
        JsonObject jsonObject = null;
        String username = "";
        String state = "";
        String baokaodian = "";
        if (!str.isEmpty()) {
            jsonObject = new JsonParser().parse(str).getAsJsonObject();
            username = jsonObject.get("username").getAsString();
            baokaodian = jsonObject.get("baokaodian").getAsString();
        }

        System.out.println("报考信息：" + str);
        System.out.println("用户名：" + username);
        System.out.println("报考点：" + baokaodian);

        Calendar calendar = Calendar.getInstance();

        Connection con = con = DbUtil.getConn();;
        Statement sm = null;
        ResultSet rs = null;

        Connection con1 = DbUtil.getConn();
        Statement sm1 = null;
        ResultSet rs1 = null;

        int baokaodian_init_id = 0;

        try {
            sm1 = con1.createStatement();
            rs1 = sm1.executeQuery("SELECT * FROM baokao WHERE baokaodian_name='" + baokaodian + "'");
            if (rs1.next()) {
                baokaodian_init_id = rs1.getInt("baokaodian_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            sm = con.createStatement();

            //根据报考点获得报考点id
            rs = sm.executeQuery("SELECT * FROM baokao WHERE baokaodian_name='" + baokaodian + "'");
            if (rs.next()) {
                int baokaodian_id = rs.getInt("baokaodian_id");
                System.out.println("报考点id：" + baokaodian_id);
                //根据用户名和年份更新考生信息、报考点，报考状态设置为已报考
                sm.executeUpdate("UPDATE stu_all_info SET stu_info = '" + jsonObject
                        + "', stu_baokaodian='" + baokaodian_id + "', stu_isfill=1 WHERE stu_username ='"
                        + username + "' AND stu_year='" + calendar.get(Calendar.YEAR) + "'");
                //查询本年和同报考点数字最大的报考号
                rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_year='" + calendar.get(Calendar.YEAR)
                        + "' AND stu_baokaodian='" + baokaodian + "' ORDER BY stu_baokaohao DESC LIMIT 1");
                if (rs.next()) {
                    String baokaohao = String.valueOf(rs.getInt("stu_baokaohao") + 1);
                    System.out.println("最终报考号：" + baokaohao);
                    // 根据用户名更新报考号
                    sm.executeUpdate("UPDATE stu_all_info SET stu_baokaohao='" + baokaohao + "' WHERE " +
                            "stu_username='" + username + "' AND stu_year='" + calendar.get(Calendar.YEAR)
                            + "' AND stu_baokaodian='" + baokaodian + "'");
                    state = baokaohao;
                } else {
                    String baokaohao = String.valueOf(baokaodian_init_id) + "0001";
                    sm.executeUpdate("UPDATE stu_all_info SET stu_baokaohao='" + baokaohao + "' WHERE " +
                            "stu_username='" + username + "' AND stu_year='" + calendar.get(Calendar.YEAR)
                            + "' AND stu_baokaodian='" + baokaodian + "'");
                    state = baokaohao;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, sm, rs);
        }
        resp.getWriter().print(state);
        System.out.println("**************Android提交报考信息**************");
    }
}
