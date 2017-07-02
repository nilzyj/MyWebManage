package DAO.DaoImpl;

import DAO.StudentDAO;
import Model.Student;
import Model.StudentInfo;
import Util.DbUtil;
import Util.PinYinUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.regexp.internal.RESyntaxException;

import javax.swing.text.html.parser.Parser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
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
     *
     * @return 全部考生信息，包括历年报考信息
     * @throws Exception sqlexception
     */
    @Override
    public List<Student> getStudentInfo(String pageNum) throws Exception {
//        LIMIT 5,10;  // 检索记录行 6-15
        int page = Integer.parseInt(pageNum);
        System.out.println("页" + page);
        sm = con.createStatement();
        if (page == 1) {
            rs = sm.executeQuery("SELECT * FROM stu_all_info LIMIT 20");
        } else {
            rs = sm.executeQuery("SELECT * FROM stu_all_info LIMIT "
                    + ((page - 1) * 20) + ", 20");
        }
        studentToList(rs);
        return studentList;
    }

    /**
     * 获取全部报考考生信息
     *
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
     *
     * @return 修改是否成功
     * @throws Exception sqlexception
     */
    @Override
    public boolean modifyStudent() throws Exception {

        return false;
    }

    /**
     * 删除考生信息
     *
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
     *
     * @param strings 姓名、报考点、报考号
     * @return studentToList(rs) 查询所有符合条件的list
     * @throws Exception
     */
    public List<Student> searchStudent(String[] strings) throws Exception {
        System.out.println("searchStudent——strings:" + strings[0] + strings[1]);
        sm = con.createStatement();
        String sql = "select * from stu_all_info where 1=1";

        if (!"".equals(strings[0])) {
            sql = sql + " and stu_year='" + strings[0] + "'";
        }
        if (!"".equals(strings[1])) {
            sql = sql + " and stu_name like '%" + strings[1] + "%'";
        }
        if (!"".equals(strings[2])) {
            sql = sql + " and stu_baokaodian like '%" + strings[2] + "%'";
        }
        if (!"".equals(strings[3])) {
            sql = sql + " and stu_baokaohao like '%" + strings[3] + "%'";
        }
        rs = sm.executeQuery(sql);
        studentToList(rs);
        return studentList;
    }

    @Override
    public List<Student> searchStudent(String pageNum, String[] strings) throws Exception {
        int page = Integer.parseInt(pageNum);
        System.out.println("页" + page);
        sm = con.createStatement();
        String sql = "";
        if (page == 1) {
            sql = "SELECT * FROM stu_all_info where 1=1";

            if (!"".equals(strings[0])) {
                sql = sql + " and stu_year='" + strings[0] + "'";
            }
            if (!"".equals(strings[1])) {
                sql = sql + " and stu_name like '%" + strings[1] + "%'";
            }
            if (!"".equals(strings[2])) {
                sql = sql + " and stu_baokaodian like '%" + strings[2] + "%'";
            }
            if (!"".equals(strings[3])) {
                sql = sql + " and stu_baokaohao like '%" + strings[3] + "%'";
            }
            sql = sql + " LIMIT 20";
        } else {
            sql = "SELECT * FROM stu_all_info where 1=1";

            if (!"".equals(strings[0])) {
                sql = sql + " and stu_year='" + strings[0] + "'";
            }
            if (!"".equals(strings[1])) {
                sql = sql + " and stu_name like '%" + strings[1] + "%'";
            }
            if (!"".equals(strings[2])) {
                sql = sql + " and stu_baokaodian like '%" + strings[2] + "%'";
            }
            if (!"".equals(strings[3])) {
                sql = sql + " and stu_baokaohao like '%" + strings[3] + "%'";
            }
            sql = sql + " LIMIT " + ((page - 1) * 20) + ", 20";
        }

        System.out.println("searchStudent——strings:" + strings[0] + strings[1]);
        System.out.println("sql:" + sql);
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
        Calendar calendar = Calendar.getInstance();
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT count(*) count FROM stu_all_info WHERE stu_year='"
                + calendar.get(Calendar.YEAR) + "'");
        if (rs.next()) {
            number = rs.getInt("count");
        }
        return number;
    }

    @Override
    public int getBaokaoNumber() throws Exception {
        int number = 0;
        Calendar calendar = Calendar.getInstance();
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT count(*) count FROM stu_all_info WHERE stu_year='"
                + calendar.get(Calendar.YEAR) + "' AND stu_isfill=1");
        if (rs.next()) {
            number = rs.getInt("count");
        }
        return number;
    }

    /**
     * 将rs中符合条件的集合放入list
     *
     * @param rs resultset
     * @return 符合条件的数据
     * @throws Exception sqlexception
     */

    private void studentToList(ResultSet rs) throws Exception {
        while (rs.next()) {

            if (rs.getString("stu_info") != null) {
                int id_stu_all_info = rs.getInt("id_stu_all_info");
                String stu_username = rs.getString("stu_username");
                String stu_name = rs.getString("stu_name");
                JsonObject stu_info;

                stu_info = new JsonParser()
                        .parse(rs.getString("stu_info"))
                        .getAsJsonObject();

                int stu_year = rs.getInt("stu_year");
                String stu_baokaodian = rs.getString("stu_baokaodian");
                if (stu_baokaodian == null)
                    stu_baokaodian = "未报考";
                int stu_baokaohao_num = rs.getInt("stu_baokaohao");
                String stu_baokaohao;
                if (stu_baokaohao_num == -1) {
                    stu_baokaohao = "未报考";
                } else {
                    stu_baokaohao = String.valueOf(stu_baokaohao_num);
                }


                Student student = new Student(
                        id_stu_all_info,
                        stu_username,
                        stu_name,
                        stu_info,
                        stu_year,
                        stu_baokaodian,
                        stu_baokaohao
                );
                studentList.add(student);
            }
        }
        DbUtil.dbClose(con, sm, rs);
        System.out.println("studentToList--放入list");
    }

}
