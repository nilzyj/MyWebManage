package DAO;

import Model.Student;
import Model.StudentInfo;

import java.util.List;

/**
 * Created by dim on 2017/5/16.
 */
public interface StudentDAO {
    public List<Student> getStudentInfo(String page) throws Exception;
    public List<Student> getStudentInfo() throws Exception;
    public boolean modifyStudent() throws Exception;
    public boolean deleteStudent(int studentId) throws Exception;
    public List<Student> searchStudent(String[] strings) throws Exception;
    public List<Student> searchStudent(String pageNum, String[] strings) throws Exception;
    public int getNumber() throws Exception;
    public int getBaokaoNumber() throws Exception;
}
