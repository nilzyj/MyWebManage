package DAO.DaoImpl;

import DAO.InvalidActionDAO;
import Model.InvalidAction;
import Util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dim on 2017/5/18.
 */
public class InvalidActionDaoImpl implements InvalidActionDAO {
    private List<InvalidAction> invalidActionList = new ArrayList<InvalidAction>();
    private Connection con = DbUtil.getConn();
    private Statement sm = null;
    private ResultSet rs = null;

    /**
     * @return 违规行为
     * @throws Exception
     */
    @Override
    public List<InvalidAction> getInvalidAction() throws Exception {
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM invalid_action_info");
        while (rs.next()) {
            invalidActionToList(rs);
        }
        DbUtil.dbClose(con, sm, rs);
        return invalidActionList;
    }

    @Override
    public boolean getInvalidAction(String username) throws Exception {
        //true:能报考，false:不能报考
        boolean isInvalid = true;
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM invalid_action_info WHERE stu_username='"
                + username + "'");
        while (rs.next()) {
            if (rs.getInt("invalid_action_if_baokao") == 0) {
                isInvalid = false;
            }
        }
        DbUtil.dbClose(con, sm, rs);
        return isInvalid;
    }

    /**
     * 添加违规行为
     * @throws Exception
     */
    @Override
    public boolean addInvalidAction(String name, String action, String id, int year, String add_name, String time) throws Exception {
        boolean flag = false;
        Connection con1 = DbUtil.getConn();
        Statement sm1 = con1.createStatement();
        ResultSet rs1 = null;

        Connection  con2 = DbUtil.getConn();
        Statement sm2 = con2.createStatement();
        ResultSet rs2 = null;

        rs1 = sm1.executeQuery("SELECT * FROM stu_account WHERE stu_name='" + name + "' AND stu_id='" + id + "'");
        if (rs1.next()) {
//            rs2 = sm2.executeQuery("SELECT * FROM stu_all_info WHERE stu_username='" + rs1.getString("stu_username") + "'");
            sm = con.createStatement();
            sm.executeUpdate("INSERT INTO invalid_action_info " +
                    "(invalid_stu_name, stu_username, invalid_action, invalid_year, invalid_add_person, invalid_add_time)" +
                    " VALUES ('" + name + "', '" + rs1.getString("stu_username") + "', '" + action + "', '" + year +  "', '" + add_name +  "', '" + time + "')");
            flag = true;
        } else {
            flag = false;
        }
        System.out.println("invalid_action_insert");
        DbUtil.dbClose(con2, sm2, rs2);
        DbUtil.dbClose(con1, sm1, rs1);
        DbUtil.dbClose(con, sm, rs);
        return flag;
    }

    /**
     * 删除违规行为
     * @throws Exception
     */
    @Override
    public void deleteInvalidAction() throws Exception {
        sm = con.createStatement();
        sm.executeUpdate("");

        DbUtil.dbClose(con, sm, rs);
    }

    /**
     * 修改是否能参加考试
     * @param invalid_action_id 修改违规行为的id
     * @param ifCan 是否
     * @throws Exception
     */
    @Override
    public void modifyIfCanExam(String invalid_action_id, String ifCan) throws Exception {
        sm = con.createStatement();
        int if_baokao = 0;
        if (ifCan.equals("yes")) {
            if_baokao = 1;
        }
        sm.executeUpdate("UPDATE invalid_action_info"
                + " SET invalid_action_if_baokao='" + if_baokao
                + "' WHERE id_invalid_action_info='" + invalid_action_id + "'");
    }

    @Override
    public List<InvalidAction> searchInvalidAction(String[] strings) throws Exception {
        System.out.println("searchInvalidAction——strings:" + strings[0] + strings[1]);
        sm = con.createStatement();
        String sql = "select * from invalid_action_info where 1=1";
        if(!"".equals(strings[0])) {
            sql = sql + " and invalid_year='" + strings[0] + "'";
        }
        if(!"".equals(strings[1])) {
            sql = sql + " and invalid_stu_name='" + strings[1] + "'";
        }
        if(!"".equals(strings[2])) {
            sql = sql + " and invalid_action like '%" + strings[2] + "%'";
        }
        rs = sm.executeQuery(sql);
        invalidActionToList(rs);

        return invalidActionList;
    }

    private void invalidActionToList(ResultSet rs) throws Exception{
        while (rs.next()) {
            InvalidAction invalidAction = new InvalidAction(
                    rs.getInt("id_invalid_action_info"),
                    rs.getString("stu_username"),
                    rs.getString("invalid_stu_name"),
                    rs.getString("invalid_action"),
                    rs.getInt("invalid_year"),
                    rs.getString("invalid_add_time"),
                    rs.getString("invalid_add_person"),
                    rs.getInt("invalid_action_if_baokao")
            );
            invalidActionList.add(invalidAction);
        }
    }
}
