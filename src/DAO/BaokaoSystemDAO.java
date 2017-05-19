package DAO;

/**
 * Created by dim on 2017/5/18.
 */
public interface BaokaoSystemDAO {
    public String getBaokaoSystemState() throws Exception;
    public void changeBaokaoSystemState(String state) throws Exception;
}
