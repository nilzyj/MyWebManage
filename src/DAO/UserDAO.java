package DAO;

import Model.User;

/**
 * Created by dim on 2017/4/29.
 */
public interface UserDAO {
    //验证密码
    public boolean checkLogin(User user) throws Exception;

    // 修改密码
    public String modifyPassword(User user) throws Exception;
}
