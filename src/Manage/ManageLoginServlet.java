package Manage;

import DAO.DaoImpl.StudentDaoImpl;
import DAO.DaoImpl.UserDaoImpl;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ManageLoginServlet", urlPatterns = {"/ManageLoginServlet"})
public class ManageLoginServlet extends HttpServlet {
	//管理登录
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("**************网页登录**************");
		String name = req.getParameter("name");
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		User user = new User(name, password);
		UserDaoImpl userDao = new UserDaoImpl();

		StudentDaoImpl studentDao = new StudentDaoImpl();

		try {
			session.setAttribute("studentNumber", studentDao.getNumber());
			System.out.println("num:" + studentDao.getBaokaoNumber());
			session.setAttribute("studentBaokaoNumber", studentDao.getBaokaoNumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (userDao.checkLogin(user)) {
				session.setAttribute("username", user.getName());
				if (session.getAttribute("error") != null) {
					session.removeAttribute("error");
				}
                resp.sendRedirect("index.jsp");
            } else {
				session.setAttribute("error", "用户名或密码错误");
				resp.sendRedirect("login.jsp");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("**************网页登录**************");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
