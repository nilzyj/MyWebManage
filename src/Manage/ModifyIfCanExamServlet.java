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
 * Created by dim on 2017/5/19.
 */
@WebServlet(name = "ModifyIfCanExamServlet", urlPatterns = {"/ModifyIfCanExamServlet"})
public class ModifyIfCanExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
        String invalid_action_id = request.getParameter("optionsRadios");
        String ifCan = request.getParameter("ifCan");
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();
        try {
            invalidActionDao.modifyIfCanExam(invalid_action_id, ifCan);
            invalidActionDao = new InvalidActionDaoImpl();
            invalidActionList = invalidActionDao.getInvalidAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("invalidActionList", invalidActionList);
        request.getRequestDispatcher("invalid_action.jsp").forward(request, response);
//        response.sendRedirect("invalid_action.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
