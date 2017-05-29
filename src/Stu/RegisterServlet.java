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
		System.out.println("**************Android注册**************");
		String username = req.getParameter("username");
		String name = req.getParameter("name");
		String password = req.getParameter("pwd");
		String zhengjian_leixin = req.getParameter("leixin");
		String zhengjian_haoma = req.getParameter("haoma");
		username = new String(username.getBytes("ISO8859-1"), "UTF-8");
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		zhengjian_leixin = new String(zhengjian_leixin.getBytes("ISO8859-1"), "UTF-8");

		System.out.println("注册信息--" + "用户名：" + username + ", 姓名：" + name + "，密码：" + password
				+ "， 证件类型：" + zhengjian_leixin + "，证件号码：" + zhengjian_haoma);

        Calendar now = Calendar.getInstance();

		Connection con = null;
		Statement sm = null;
		ResultSet rs = null;
		String info = "{'name': '" + name + "', 'minzu': '', 'hunfou': '', 'xingbie': '', 'waiguoyu': ''" +
				", 'yewukeer': '', 'yewukeyi': '', 'baokaodian': '', 'chushengdi': '', 'biyexuexiao': ''" +
				", 'biyezhuanye': '', 'zhucexuehao': '', 'zuihouxueli': '', 'baokaodanwei': ''" +
				", 'baokaoleibie': '', 'baokaoyuanxi': '', 'xianyijunren': '', 'zuihouxuewei': ''" +
				", 'baokaozhuanye': '', 'gudingdianhua': '', 'hukousuozaidi': '', 'kaoshifangshi': ''" +
				", 'yidongdianhua': '', 'zhengzhililun': '', 'beiyongxinxier': '', 'beiyongxinxiyi': ''" +
				", 'dianziyouxiang': '', 'jiguansuozaidi': '', 'zhengjianhaoma': '" + zhengjian_haoma + "'" +
				", 'kaoshenglaiyuan': '', 'yanjiufangxiang': '', 'zhengzhimianmao': '', 'zhuanxiangjihua': ''" +
				", 'zhengjianleixing': '" + zhengjian_leixin + "', 'biyezhengshubianhao': '', 'dingxiangjiuyedanwei': ''" +
				", 'kaoshengtongxundizhi': '', 'xuexiyugongzuojingli': '', 'xueweizhengshubianhao': ''" +
				", 'jiatingzhuyaochengyuan': '', 'kaoshengdangansuozaidi': '', 'kaoshengzuobiqingkuang': ''" +
				", 'baokaodiansuozaishengshi': '', 'hukousuozaidixiangxidizhi': '', 'huodezuihouxuelibiyenianyue': ''" +
				", 'dingxiangjiuyedanweisuozaidi': '', 'xianzaixuexihuogongzuodanwei': '', 'qudezuihouxuelidexuexixingshi': ''" +
				", 'kaoshengdangansuozaidanweidizhi': '', 'kaoshengtongxundizhiyouzhengbianma': ''" +
				", 'kaoshengdangansuozaidanweiyouzhengbianma': '', 'heshihediheyuanyinshouguohezhongjianglihuochufen': ''}";
		JsonObject jsonObject = new JsonParser().parse(info).getAsJsonObject();
		try {
			con = DbUtil.getConn();
			sm = con.createStatement();
			sm.executeUpdate("insert into stu_account (stu_username, stu_name, stu_password, stu_id, stu_id_type) values"
					+ "('" + username + "', '" + name + "', '" + password + "', '" + zhengjian_haoma + "', '" + zhengjian_leixin + "')");
			sm.executeUpdate("insert into stu_all_info (stu_username, stu_name, stu_year, stu_info) values"
                    + "('" + username + "', '" + name + "', '" + now.get(Calendar.YEAR) + "', '" + jsonObject + "')");

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DbUtil.dbClose(con, sm, rs);
		}
		resp.getWriter().print("success");
		System.out.println("**************Android注册**************");
	}
}
