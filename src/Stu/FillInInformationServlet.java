package Stu;

import Util.DbUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "FillInInformationServlet", urlPatterns = {"/FillInInformationServlet"})
public class FillInInformationServlet extends HttpServlet {
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
		String str = req.getParameter("fillData");
		str = new String(str.getBytes("iso8859-1"), "UTF-8");
		JsonObject jsonObject = null;
		String name = "";
		String state = "";
		if(!str.isEmpty()) {
			jsonObject = new JsonParser().parse(str).getAsJsonObject();
			name = jsonObject.get("name").getAsString();
		}

		System.out.print(str);
		System.out.print(name);

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			sm = con.createStatement();
			sm.executeUpdate("UPDATE stu_all_info SET stu_info = '" + jsonObject + "' WHERE stu_name ='"
					+ name +"'");

			System.out.print(jsonObject);
			state = "success";
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		    DbUtil.dbClose(con, sm, rs);
		}
		resp.getWriter().print(state);
	}
}
