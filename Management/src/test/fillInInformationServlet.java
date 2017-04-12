package test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
@WebServlet(name = "fillInInformationServlet", urlPatterns = {"/fillInInformationServlet"})
public class fillInInformationServlet extends HttpServlet {
	/**
	 * 接收报考信息
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String str = req.getParameter("data");
		JsonObject jsonObject = null;
		String name = "";
		String state = "";
		if(!str.isEmpty()) {
			jsonObject = new JsonParser().parse(str).getAsJsonObject();
			name = jsonObject.get("name").toString();
		}

		System.out.print(str);
		System.out.print(name);

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/mydb";
			con = DriverManager.getConnection(url,"root","root");
			sm = con.createStatement();
			sm.executeUpdate("UPDATE stu_account SET stu_info = '" + jsonObject + "' WHERE stu_name ="
					+ name);
			state = "success";
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
		resp.getWriter().print(state);
	}
}
