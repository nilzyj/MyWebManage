package DAO.DaoImpl;

import DAO.BaokaoSystemDAO;
import Util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dim on 2017/5/18.
 */
public class BaokaoSystemDaoImpl implements BaokaoSystemDAO {
    private Connection con = DbUtil.getConn();
    private Statement sm = null;
    private ResultSet rs = null;

    /**
     * @return 考生报考系统状态
     * @throws Exception
     */
    @Override
    public String getBaokaoSystemState() throws Exception {
        String state = null;

        sm = con.createStatement();
        rs = sm.executeQuery("SELECT * FROM system_on_off");
        if (rs.next()) {
            String systemState = String.valueOf(rs.getInt("systemState"));
            if ("1".equals(systemState)) {
                System.out.println("开启");
                state = "开启";
            } else {
                System.out.println("关闭");
                state = "关闭";
            }
        } else {
            state = "系统错误";
        }
        DbUtil.dbClose(con, sm, rs);
        return state;
    }

    /**
     * 关闭或开启考生报考系统
     * @param state
     * @throws Exception
     */
    @Override
    public void changeBaokaoSystemState(String state) throws Exception {
        sm = con.createStatement();
        if ("on".equals(state)) {
            System.out.println("on");
            sm.executeUpdate("UPDATE system_on_off SET systemState = 1");
        } else if("off".equals(state)) {
            System.out.println("off");
            sm.executeUpdate("UPDATE system_on_off SET systemState = 0");
        }
    }
}
