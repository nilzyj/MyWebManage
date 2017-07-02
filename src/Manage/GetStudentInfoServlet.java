package Manage;

import DAO.DaoImpl.StudentDaoImpl;
import Model.Student;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/16.
 */
@WebServlet(name = "GetStudentInfoServlet", urlPatterns = {"/GetStudentInfoServlet"})
public class GetStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************网页获取考生信息**************");
        String pageNum = request.getParameter("pageNum");
        System.out.println(pageNum);
        List<Student> studentList = new ArrayList<Student>();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        HttpSession session = request.getSession();
        try {
            System.out.println("GetStudentServlet");
            if (pageNum == null) {
                studentList = studentDao.getStudentInfo();
            } else {
                if (session.getAttribute("search") != null) {
                    studentList = studentDao.searchStudent(pageNum, (String[])session.getAttribute("search"));
                } else {
                    studentList = studentDao.getStudentInfo(pageNum);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = getJsonData(studentList);
        int size = new JsonParser().parse(json).getAsJsonArray().size();
        session.setAttribute("studentList", studentList);
//        session.setAttribute("json", json);
//        session.setAttribute("size", size);
        if (pageNum == null) {
            session.setAttribute("listSize", size / 20 + 1);
        }
        response.sendRedirect("manage_stu_info.jsp");
        System.out.println("**************网页获取考生信息**************");
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
