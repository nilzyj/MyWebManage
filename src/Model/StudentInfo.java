package Model;

/**
 * Created by dim on 2017/5/20.
 */
public class StudentInfo {
    private String infoName;
    private String info;

    public StudentInfo(String infoName, String info) {
        this.infoName = infoName;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoName() {

        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }
}
