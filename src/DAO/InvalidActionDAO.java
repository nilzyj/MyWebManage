package DAO;

import Model.InvalidAction;

import java.util.List;

/**
 * Created by dim on 2017/5/18.
 */
public interface InvalidActionDAO {
    public List<InvalidAction> getInvalidAction() throws Exception;
    public boolean getInvalidAction(String name) throws Exception;
    public void addInvalidAction(String name, String action, int year) throws Exception;
    public void deleteInvalidAction() throws Exception;
    public void modifyIfCanExam(String invalid_action_id, String ifCan) throws Exception;
}
