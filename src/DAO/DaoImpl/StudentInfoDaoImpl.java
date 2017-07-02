package DAO.DaoImpl;

import DAO.StudentInfoDAO;
import Model.Student;
import Model.StudentInfo;
import Util.DbUtil;
import Util.PinYinUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/20.
 */
public class StudentInfoDaoImpl implements StudentInfoDAO {
    private List<StudentInfo> studentInfoList = new ArrayList<StudentInfo>();
    private Connection con = DbUtil.getConn();
    private Statement sm = null;
    private ResultSet rs = null;
    PinYinUtil pinYinUtil = new PinYinUtil();
    String[] infos = {"证件类型", "证件号码", "民族", "婚否", "性别", "现役军人", "政治面貌",
            "籍贯所在地", "出生地", "户口所在地", "户口所在地详细地址", "考生档案所在地", "考生档案所在单位地址",
            "考生档案所在单位邮政编码", "现在学习或工作单位", "学习与工作经历", "何时何地何原因受过何种奖励或处分",
            "考生作弊情况", "家庭主要成员", "考生通讯地址", "考生通讯地址邮政编码", "固定电话", "移动电话",
            "电子邮箱", "考生来源", "毕业学校", "毕业专业", "取得最后学历的学习形式", "最后学历", "毕业证书编号",
            "获得最后学历毕业年月", "注册学号", "最后学位", "学位证书编号", "报考单位", "报考专业", "考试方式",
            "专项计划", "报考类别", "定向就业单位所在地", "定向就业单位", "报考院系", "研究方向", "政治理论", "外国语",
            "业务课一", "业务课二", "备用信息一", "备用信息二", "报考点所在省市", "报考点"};

    @Override
    public List<StudentInfo> getStudentInfo(String id) throws Exception {
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE id_stu_all_info='" +  id + "'");
        if (rs.next()) {
            if (rs.getString("stu_info") != null) {
                JsonObject jsonObject = new JsonParser().parse(rs.getString("stu_info")).getAsJsonObject();
                StudentInfo studentInfoUsername = new StudentInfo("用户名", rs.getString("stu_username"));
                studentInfoList.add(studentInfoUsername);
                StudentInfo studentInfoName = new StudentInfo("姓名", rs.getString("stu_name"));
                studentInfoList.add(studentInfoName);
                for (int i = 0; i < jsonObject.size() - 2; i++) {
                    StudentInfo studentInfo = new StudentInfo(
                            infos[i],
                            jsonObject.get(pinYinUtil.getStringPinYin(infos[i])).getAsString()
                    );
                    studentInfoList.add(studentInfo);
                }
            }
        }
        DbUtil.dbClose(con, sm, rs);
        return studentInfoList;
    }

    @Override
    public String getStudentImg(String id) throws Exception {
        String img = "";
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM stu_all_info WHERE id_stu_all_info='" + id + "'");
        if (rs.next()) {
            img = rs.getString("stu_photo");
        }
        DbUtil.dbClose(con, sm, rs);
        return img;
    }
}
