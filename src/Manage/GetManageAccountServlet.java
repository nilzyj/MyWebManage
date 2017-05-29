package Manage;

import DAO.DaoImpl.UserDaoImpl;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/28.
 */
@WebServlet(name = "GetManageAccountServlet", urlPatterns = {"/GetManageAccountServlet"})
public class GetManageAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("**************网页获取账号信息**************");
        List<User> userList = new ArrayList<User>();
        UserDaoImpl userDao = new UserDaoImpl();
        try {
            userList = userDao.getUser();
            System.out.println(userList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("userList", userList);
        response.sendRedirect("manage_account.jsp");
        System.out.println("**************网页获取账号信息**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
