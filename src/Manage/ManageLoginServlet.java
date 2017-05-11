package Manage;

import DAO.DaoImpl.UserDaoImpl;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		String password = req.getParameter("password");
		System.out.print(name + " " + password);

		User user = new User(name, password);
		UserDaoImpl userDao = new UserDaoImpl();

		try {
			if (userDao.checkLogin(user)) {
                resp.sendRedirect("index.jsp");
            } else {
				resp.sendRedirect("login.jsp");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
