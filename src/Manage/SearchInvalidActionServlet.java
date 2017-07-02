package Manage;

import DAO.DaoImpl.InvalidActionDaoImpl;
import Model.InvalidAction;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/16.
 */
@WebServlet(name = "SearchInvalidActionServlet", urlPatterns = {"/SearchInvalidActionServlet"})
public class SearchInvalidActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************网页查询违规行为**************");
        String year = request.getParameter("year");
        String name = request.getParameter("name");
        String invalidAction = request.getParameter("invalidAction");
        List<InvalidAction> searchInvalidList = new ArrayList<InvalidAction>();
        System.out.println("SearchStudentServlet——查询信息：" + year + name + invalidAction);
        HttpSession session = request.getSession();
        InvalidActionDaoImpl invalidActionDao = new InvalidActionDaoImpl();

        if (!"".equals(year + name + invalidAction)) {
            try {
                System.out.println("SearchStudentServlet——searchList");
                searchInvalidList = invalidActionDao.searchInvalidAction(new String[]{year, name, invalidAction});
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(searchInvalidList.isEmpty()) {
                System.out.println("list为空，未查询到");
                session.setAttribute("searchResult", "查询结果为空");
            } else {
                System.out.println("list不为空：" + searchInvalidList.get(0).getName());
//                String json = getJsonData(searchInvalidList);
//                int size = new JsonParser().parse(json).getAsJsonArray().size();
//                session.setAttribute("listSize", size / 20 + 1);
                session.setAttribute("invalidActionList", searchInvalidList);
                System.out.println("list.size:" + searchInvalidList.size());
                session.removeAttribute("searchResult");
            }
        } else {
            System.out.println("search为空");
            session.setAttribute("searchResult", "请输入查询条件");
            try {
                session.setAttribute("invalidActionList", invalidActionDao.getInvalidAction());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("request");
        response.sendRedirect("invalid_action.jsp");
        System.out.println("**************网页查询违规行为**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public String getJsonData(List<?> list) {
        Gson gson = new Gson();
        String jsonstring = gson.toJson(list);
        return jsonstring;
    }

}
