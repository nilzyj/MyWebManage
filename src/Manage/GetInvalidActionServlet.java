package Manage;

import DAO.DaoImpl.InvalidActionDaoImpl;
import Model.InvalidAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/18.
 */
@WebServlet(name = "GetInvalidActionServlet", urlPatterns = {"/GetInvalidActionServlet"})
public class GetInvalidActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();
        try {
            invalidActionList = invalidActionDao.getInvalidAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("invalidActionList", invalidActionList);
        response.sendRedirect("invalid_action.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
