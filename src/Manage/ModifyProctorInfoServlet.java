package Manage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dim on 2017/4/26.
 */
@WebServlet(name = "ModifyProctorInfoServlet",urlPatterns = {"/ModifyProctorInfoServlet"})
public class ModifyProctorInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proctorName = request.getParameter("proctorName");
        String examInfo = request.getParameter("examInfo");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
