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
            InvalidAction invalidAction = new InvalidAction(
                    rs.getInt("id_invalid_action_info"),
                    rs.getString("invalid_stu_name"),
                    rs.getString("invalid_action"),
                    rs.getInt("invalid_year"),
                    rs.getInt("invalid_action_if_baokao")
            );
            invalidActionList.add(invalidAction);
        }
        DbUtil.dbClose(con, sm, rs);
        return invalidActionList;
    }

    @Override
    public boolean getInvalidAction(String name) throws Exception {
        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM invalid_action_info WHERE invalid_stu_name='"
                + name + "'");
        if (rs.next())
            return false;
        else
            return true;
    }

    /**
     * 添加违规行为
     * @throws Exception
     */
    @Override
    public void addInvalidAction(String name, String action, int year) throws Exception {
        sm = con.createStatement();
        sm.executeUpdate("INSERT INTO invalid_action_info " +
                "(invalid_stu_name, invalid_action, invalid_year)" +
                " VALUES ('" + name + "', '" + action + "', '" + year + "')");
        System.out.println("invalid_action_insert");
        DbUtil.dbClose(con, sm, rs);
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
}
