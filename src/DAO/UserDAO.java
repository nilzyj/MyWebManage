package DAO;

import Model.User;

/**
 * Created by dim on 2017/4/29.
 */
public interface UserDAO {
    public boolean checkLogin(User user) throws Exception;
    public boolean modifyPassword(User user) throws Exception;
}
