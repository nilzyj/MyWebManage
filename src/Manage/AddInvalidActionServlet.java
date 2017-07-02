package Manage;

import DAO.DaoImpl.InvalidActionDaoImpl;
import Model.InvalidAction;
import org.omg.CORBA.DynAnyPackage.Invalid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dim on 2017/5/19.
 */
@WebServlet(name = "AddInvalidActionServlet", urlPatterns = {"/AddInvalidActionServlet"})
public class AddInvalidActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************网页添加违规信息**************");
        List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
        String invalid_action_name = request.getParameter("invalid_action_name");
        System.out.println(invalid_action_name);
        String invalid_action_id = request.getParameter("invalid_action_id");
        System.out.println(invalid_action_id);
        String invalid_action = request.getParameter("invalid_action");
        int invalid_action_year = Calendar.getInstance().get(Calendar.YEAR);
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Calendar c = Calendar.getInstance();
        String time = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
        try {
            boolean flag = invalidActionDao.addInvalidAction(invalid_action_name, invalid_action, invalid_action_id,
                    invalid_action_year, username, time);
            if (!flag) {
                session.setAttribute("searchResult", "添加失败，姓名与身份证不匹配");
            }
            invalidActionDao = new InvalidActionDaoImpl();
            invalidActionList = invalidActionDao.getInvalidAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("invalidActionList", invalidActionList);
        response.sendRedirect("invalid_action.jsp");
        System.out.println("**************网页添加违规信息**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
