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
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");

        Calendar now = Calendar.getInstance();

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			sm = con.createStatement();
			sm.executeUpdate("insert into stu_account (stu_name, stu_password) values"
					+ "('" + name + "', '" + password + "')");
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
