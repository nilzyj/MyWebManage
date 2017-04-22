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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
		//		String text = request.getParameter("param");
		//		
		//		response.getWriter().println(text);
	}

	//android注册
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("pwd");
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			con = DriverManager.getConnection(url,"root","root");
			sm = con.createStatement();
			sm.executeUpdate("insert into stu_account (stu_name, stu_password) values"
					+ "('" + name + "', '" + password + "')");
			resp.getWriter().print("success");
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
