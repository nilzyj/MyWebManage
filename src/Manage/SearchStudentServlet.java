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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("**************网页查询考生信息**************");
        String year = request.getParameter("year");
        String name = request.getParameter("name");
        String baokaodian = request.getParameter("baokaodian");
        String baokaohao = request.getParameter("baokaohao");
        List<Student> searchStuList = new ArrayList<Student>();
        System.out.println("SearchStudentServlet——查询信息：" + year + name + baokaodian + baokaohao);
        HttpSession session = request.getSession();
        StudentDaoImpl studentDao = new StudentDaoImpl();

        if (!"".equals(year + name + baokaodian + baokaohao)) {
            try {
                System.out.println("SearchStudentServlet——searchList");
                searchStuList = studentDao.searchStudent(new String[]{year, name, baokaodian, baokaohao});
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(searchStuList.isEmpty()) {
                System.out.println("list为空，未查询到");
                session.setAttribute("searchResult", "查询结果为空");
            } else {
                System.out.println("list不为空：" + searchStuList.get(0).getName());

                session.setAttribute("studentList", searchStuList);
                System.out.println("list.size" + searchStuList.size());
                session.removeAttribute("searchResult");
            }
        } else {
            System.out.println("search为空");
            session.setAttribute("searchResult", "请输入查询条件");
            try {
                session.setAttribute("studentList", studentDao.getStudentInfo());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("manage_stu_info.jsp");
        System.out.println("**************网页查询考生信息**************");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
