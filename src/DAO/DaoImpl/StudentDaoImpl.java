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
    private List<Student> studentList = new ArrayList<Student>();

    /**
     * 获取全部报考考生信息
     * @return 全部考生信息，包括历年报考信息
     * @throws Exception sqlexception
     */
    @Override
    public List<Student> getStudentInfo() throws Exception {
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM stu_all_info");
        studentToList(rs);
        return studentList;
    }

    /**
     * 修改学生信息
     * @return 修改是否成功
     * @throws Exception sqlexception
     */
    @Override
    public boolean modifyStudent() throws Exception {

        return false;
    }

    /**
     * 删除考生信息
     * @param studentId 获取的考生序号
     * @return 删除是否成功
     * @throws Exception sqlexception
     */
    @Override
    public boolean deleteStudent(int studentId) throws Exception {
        return false;
    }

    /**
     * 考生信息查询
     * @param strings 姓名、报考点、报考号
     * @return studentToList(rs) 查询所有符合条件的list
     * @throws Exception
     */
    public List<Student> searchStudent(String[] strings) throws Exception {
        System.out.println("searchStudent——strings:" + strings[0] + strings[1]);
        sm = con.createStatement();
        String sql = "select * from stu_all_info where 1=1";
        if(!"".equals(strings[0])) {
            sql = sql + " and stu_year='" + strings[0] + "'";
        }
        if(!"".equals(strings[1])) {
            sql = sql + " and stu_name='" + strings[1] + "'";
        }
        if(!"".equals(strings[2])) {
            sql = sql + " and stu_baokaodian='" + strings[2] + "'";
        }
        if(!"".equals(strings[3])) {
            sql = sql + " and stu_baokaohao='" + strings[3] + "'";
        }
        rs = sm.executeQuery(sql);
        studentToList(rs);
        return studentList;
    }

    /**
     * @return 报考考生数量，
     * @throws Exception sqlexception
     */
    // TODO 只获取当前年报考考生数量
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

    /**
     * 将rs中符合条件的集合放入list
     * @param rs resultset
     * @return 符合条件的数据
     * @throws Exception sqlexception
     */
    private void studentToList(ResultSet rs) throws Exception {
        while (rs.next()) {
            if (rs.getString("stu_info") != null) {
                Student student = new Student(
                        rs.getInt("id_stu_all_info"),
                        rs.getString("stu_name"),
                        new JsonParser()
                                .parse(rs.getString("stu_info"))
                                .getAsJsonObject(),
                        rs.getInt("stu_year"),
                        rs.getString("stu_baokaodian"),
                        rs.getString("stu_baokaohao")
                );
                studentList.add(student);
            }
        }
        System.out.println("studentToList--放入list");
    }
}
