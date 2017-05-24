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
import java.sql.Statement;
import java.util.Calendar;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	//android注册
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("pwd");
		String zhengjian_leixin = req.getParameter("leixin");
		String zhengjian_haoma = req.getParameter("haoma");
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		zhengjian_leixin = new String(zhengjian_leixin.getBytes("ISO8859-1"), "UTF-8");

//		switch (zhengjian_leixin) {
//            case "居民身份证":
//                zhengjian_haoma += "1";
//                break;
//            case "港澳台身份证":
//                zhengjian_haoma += "2";
//                break;
//            case "华侨身份证":
//                zhengjian_haoma += "3";
//                break;
//            default:
//                //其他
//                zhengjian_haoma += "0";
//                break;
//        }

        Calendar now = Calendar.getInstance();

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			sm = con.createStatement();
			sm.executeUpdate("insert into stu_account (stu_name, stu_password, stu_id, stu_id_type) values"
					+ "('" + name + "', '" + password + "', '" + zhengjian_haoma + "', '" + zhengjian_leixin + "')");
			sm.executeUpdate("insert into stu_all_info (stu_name, stu_year) values"
                    + "('" + name + "', '" + now.get(Calendar.YEAR) + "')");
			resp.getWriter().print("success");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DbUtil.dbClose(con, sm, rs);
		}
	
	}
}
