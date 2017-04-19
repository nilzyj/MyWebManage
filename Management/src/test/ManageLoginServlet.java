package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManageLoginServlet", urlPatterns = {"/ManageLoginServlet"})
public class ManageLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//管理登录
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		req.setCharacterEncoding("UTF-8");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/mydb";
			con = DriverManager.getConnection(url,"root","root");
			sm = con.createStatement();
			rs = sm.executeQuery("select * from manage_account where manage_name='"+name+"'");
			if(rs.next()) {
				if(rs.getString("manage_password").equals(password))
				{
					resp.sendRedirect("page/index.html");//密码正确
				}
				else
				{
					resp.sendRedirect("test2.jsp");//密码错误
//					session.setAttribute("state", "wrong");
				}
			}
			else
			{
				resp.sendRedirect("test2.jsp");//用户不存在
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
