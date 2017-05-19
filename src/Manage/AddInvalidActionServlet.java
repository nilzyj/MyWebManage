package Manage;

import DAO.DaoImpl.InvalidActionDaoImpl;
import Model.InvalidAction;
import org.omg.CORBA.DynAnyPackage.Invalid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dim on 2017/5/19.
 */
@WebServlet(name = "AddInvalidActionServlet", urlPatterns = {"/AddInvalidActionServlet"})
public class AddInvalidActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
        String invalid_action_name = request.getParameter("invalid_action_name");
        String invalid_action = request.getParameter("invalid_action");
        int invalid_action_year = Calendar.getInstance().get(Calendar.YEAR);
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();
        try {
            invalidActionDao.addInvalidAction(invalid_action_name, invalid_action,
                    invalid_action_year);
             invalidActionDao = new InvalidActionDaoImpl();
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
