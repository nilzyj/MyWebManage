package DAO;

import Model.User;

/**
 * Created by dim on 2017/4/29.
 */
public interface UserDAO {
    public boolean checkLogin(User user) throws Exception;
    public boolean modifyPassword(User user, String newPassword) throws Exception;
    public void addUser(User user) throws Exception;
    public void deleteUser(User user) throws Exception;
}
