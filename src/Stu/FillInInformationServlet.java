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
import java.util.Calendar;

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

		Calendar calendar = Calendar.getInstance();

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			con = DbUtil.getConn();
			sm = con.createStatement();
			sm.executeUpdate("UPDATE stu_all_info SET stu_info = '" + jsonObject + "' WHERE stu_name ='"
					+ name + "' AND stu_year='" + calendar.get(Calendar.YEAR) + "'");

			rs = sm.executeQuery("SELECT * FROM stu_all_info ORDER BY id_stu_all_info LIMIT 1");
			if (rs.next()) {
				int id = rs.getInt("id_stu_all_info");
				rs = sm.executeQuery("SELECT * FROM baokao WHERE baokaodian_name='哈工大'");

				String baokaohao;
				if (rs.next()) {
					String number = String.valueOf(id + 1);
					String temp = "0000";
					number = temp.substring(0, 4 - number.length()) + number;
					baokaohao = String.valueOf(rs.getInt("baokaodian_id")) + number;
					sm.executeUpdate("UPDATE stu_all_info SET stu_baokaohao='" + baokaohao + "' WHERE stu_name='" +
							name + "' AND stu_year='" + calendar.get(Calendar.YEAR) + "'");
					state = baokaohao;
				}
			}
			System.out.print(jsonObject);
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
