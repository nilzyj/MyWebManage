package Manage;

import DAO.DaoImpl.BaokaoSystemDaoImpl;
import Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/18.
 */
@WebServlet(name = "ManageBaokaoServlet", urlPatterns = {"/ManageBaokaoServlet"})
public class ManageBaokaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************网页管理报考系统**************");
        String state = request.getParameter("state");
        BaokaoSystemDaoImpl baokaoSystemDao = new BaokaoSystemDaoImpl();
        try {
            if (!"".equals(state)) {
                System.out.println("change");
                baokaoSystemDao.changeBaokaoSystemState(state);
            }
            System.out.println("get");
            String systemState = baokaoSystemDao.getBaokaoSystemState();
            request.getSession().setAttribute("systemState", systemState);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("manage_baokao.jsp");
        System.out.println("**************网页管理报考系统**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
