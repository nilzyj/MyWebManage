package DAO;

import Model.Student;

import java.util.List;

/**
 * Created by dim on 2017/5/16.
 */
public interface StudentDAO {
    /**
     * 获取student信息
     * @return 返回student信息
     * @throws Exception sqlexception
     */
    public List<Student> getStudentInfo() throws Exception;

    /**
     * 修改学生信息
     * @return 修改是否成功
     * @throws Exception sqlexception
     */
    public boolean modifyStudent() throws Exception;

    /**
     * @return 删除是否成功
     * @throws Exception sqlexception
     */
    public boolean deleteStudent(int studentId) throws Exception;

    /**
     * 根据姓名、报考点、报考号查询
     * @param strings 姓名、报考点、报考号
     * @return 查询结果
     * @throws Exception sqlexception
     */
    public List<Student> searchStudent(String[] strings) throws Exception;

    /**
     * @return 报考考生数量
     * @throws Exception sqlexception
     */
    public int getNumber() throws Exception;
}
