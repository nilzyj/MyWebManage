package DAO;

import Model.InvalidAction;

import java.util.List;

/**
 * Created by dim on 2017/5/18.
 */
public interface InvalidActionDAO {
    public List<InvalidAction> getInvalidAction() throws Exception;
    public boolean getInvalidAction(String username) throws Exception;
    public boolean addInvalidAction(String name, String action, String id, int year, String add_name, String time) throws Exception;
    public void deleteInvalidAction() throws Exception;
    public void modifyIfCanExam(String invalid_action_id, String ifCan) throws Exception;
    public List<InvalidAction> searchInvalidAction(String[] strings) throws Exception;
}
