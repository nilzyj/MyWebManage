package Stu;

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
@WebServlet(name = "GetInvalidInfoServlet")
public class GetInvalidInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();
        try {
            if (invalidActionDao.getInvalidAction(name)) {
                response.getWriter().print("有违规行为，无法参加考试");
            } else {
                response.getWriter().print("无违规行为，可以参加考试");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
