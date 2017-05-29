package Manage;

import DAO.DaoImpl.StudentInfoDaoImpl;
import Model.StudentInfo;

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
 * Created by dim on 2017/5/20.
 */
@WebServlet(name = "ShowStudentInfoServlet", urlPatterns = {"/ShowStudentInfoServlet"})
public class ShowStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************网页显示考生信息**************");
        String id = request.getParameter("student_info_id");
        System.out.println("查看考生id：" + id);
        List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
        StudentInfoDaoImpl studentInfoDao = new StudentInfoDaoImpl();
        try {
            studentInfoList = studentInfoDao.getStudentInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("studentInfoList", studentInfoList);
        response.sendRedirect("stu_info.jsp");
        System.out.println("**************网页显示考生信息**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
