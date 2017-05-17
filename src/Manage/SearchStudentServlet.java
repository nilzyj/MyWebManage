package Manage;

import DAO.DaoImpl.StudentDaoImpl;
import Model.Student;

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
@WebServlet(name = "SearchStudentServlet", urlPatterns = {"/SearchStudentServlet"})
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String baokaodian = request.getParameter("baokaodian");
        String baokaohao = request.getParameter("baokaohao");
        List<Student> searchList = new ArrayList<Student>();
        System.out.println(name + baokaodian + baokaohao);
        StudentDaoImpl studentDao = new StudentDaoImpl();
        try {
            searchList = studentDao.searchStudent(new String[]{name, baokaodian, baokaohao});
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("list", searchList);
        response.sendRedirect("manage_stu_info.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
