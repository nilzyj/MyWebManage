package DAO;

import Model.StudentInfo;

import java.util.List;

/**
 * Created by dim on 2017/5/20.
 */
public interface StudentInfoDAO {
    public List<StudentInfo> getStudentInfo(String id) throws Exception;
}
