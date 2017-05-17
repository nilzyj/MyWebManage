package DAO.DaoImpl;

import DAO.UserDAO;
import Model.User;
import Util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dim on 2017/4/29.
 */
public class UserDaoImpl implements UserDAO {
    private Connection con = DbUtil.getConn();
    private Statement sm = null;
    private ResultSet rs = null;

    /**
     * @param user 用户bean
     * @return 验证密码结果
     * @throws Exception sqlexception
     */
    @Override
    public boolean checkLogin(User user) throws Exception {
        boolean flag = false;
        sm = con.createStatement();
        rs = sm.executeQuery("select * from manage_account " +
                "where manage_name='" + user.getName() + "'AND manage_password='" + user.getPassword() + "'");
        if (rs.next()) {
            flag = true;//密码正确
        }
        DbUtil.dbClose(con, sm, rs);
        return flag;
    }

    /**
     * @param user 修改后的user bean
     * @return 修改是否成功
     * @throws Exception sqlexception
     */
    @Override
    public boolean modifyPassword(User user) throws Exception {
        return false;
    }
}
