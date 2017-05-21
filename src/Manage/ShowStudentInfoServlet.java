package Manage;

import DAO.DaoImpl.StudentInfoDaoImpl;
import Model.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/20.
 */
@WebServlet(name = "ShowStudentInfoServlet", urlPatterns = {"/ShowStudentInfoServlet"})
public class ShowStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("student_info_id");
        List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
        StudentInfoDaoImpl studentInfoDao = new StudentInfoDaoImpl();
        try {
            studentInfoList = studentInfoDao.getStudentInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO 修改点击不同考生显示相同信息
        request.getSession().setAttribute("studentInfoList", studentInfoList);
        response.sendRedirect("stu_info.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
