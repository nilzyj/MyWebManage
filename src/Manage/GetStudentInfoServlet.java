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
@WebServlet(name = "GetStudentInfoServlet", urlPatterns = {"/GetStudentInfoServlet"})
public class GetStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<Student>();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        HttpSession session = request.getSession();
        try {
            studentList = studentDao.getStudentInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("list", studentList);
        response.sendRedirect("manage_stu_info.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
