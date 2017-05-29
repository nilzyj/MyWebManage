package Stu;

import DAO.DaoImpl.InvalidActionDaoImpl;
import Model.InvalidAction;
import Util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/18.
 */
@WebServlet(name = "GetInvalidInfoServlet", urlPatterns = {"/GetInvalidInfoServlet"})
public class GetInvalidInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************Android获取违规行为**************");
        String username = request.getParameter("username");
        String state = "";

        List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();
        try {
            if (invalidActionDao.getInvalidAction(username)) {
                state = "无违规行为，可以参加考试";
            } else {
                state = "有违规行为，无法参加考试";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        state = URLEncoder.encode(state, "UTF-8");
        response.getWriter().print(state);
        System.out.println("**************Android获取违规行为**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
