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
public class UserDaoImpl implements UserDAO{
    private Connection con = DbUtil.getConn();
    @Override
    public boolean checkLogin(User user) throws Exception {
        boolean flag = false;
        Statement sm = null;
        ResultSet rs = null;
        try {
            sm = con.createStatement();
            rs = sm.executeQuery("select * from manage_account " +
                    "where manage_name='"+user.getName()+"'AND manage_password='" + user.getPassword() + "'");
            if(rs.next()) {
                flag = true;//密码正确
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            DbUtil.dbClose(con, sm, rs);
        }
        return flag;
    }

    @Override
    public String modifyPassword(User user) throws Exception {
        return null;
    }
}
