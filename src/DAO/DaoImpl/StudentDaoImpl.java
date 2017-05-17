package DAO.DaoImpl;

import DAO.StudentDAO;
import Model.Student;
import Util.DbUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.text.html.parser.Parser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/16.
 */
public class StudentDaoImpl implements StudentDAO {
    private Connection con = DbUtil.getConn();
    private Statement sm = null;
    private ResultSet rs = null;
    private List<Student> list = new ArrayList<Student>();

    @Override
    public List<Student> getStudentInfo() throws Exception {
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM stu_all_info");
        return studentToList(rs);
    }

    @Override
    public boolean modifyStudent() throws Exception {

        return false;
    }

    @Override
    public boolean deleteStudent(int studentId) throws Exception {
        return false;
    }

    public List<Student> searchStudent(String[] strings) throws Exception {
        System.out.println("strings:" + strings[0]);
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE stu_name='" + strings[0] + "'");
//                + "' AND '" + "");
        return studentToList(rs);
    }

    private List<Student> studentToList(ResultSet rs) throws Exception {
        while (rs.next()) {
            Student student = new Student();
            student.setID(rs.getInt("id_stu_all_info"));
            student.setName(rs.getString("stu_name"));
            if (rs.getString("stu_info") != null) {
                student.setJsonInfo(new JsonParser()
                        .parse(rs.getString("stu_info"))
                        .getAsJsonObject());
            } else {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("name", "zyj");
                student.setJsonInfo(jsonObject);
            }
            list.add(student);
            System.out.println("list:" + list.get(0).getName());
        }
        return list;
    }

    @Override
    public int getNumber() throws Exception {
        int number = 0;
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT count(*) count FROM stu_all_info");
        if(rs.next()) {
            number = rs.getInt("count");
        }
        return number;
    }
}
