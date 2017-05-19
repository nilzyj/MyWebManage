package Model;

/**
 * Created by dim on 2017/5/18.
 */
public class InvalidAction {
    private int ID;
    private String name;
    private String invalidAction;
    private int year;
    private int ifCanExam;

    public InvalidAction(int ID, String name, String invalidAction, int year, int ifCanExam) {
        this.ID = ID;
        this.name = name;
        this.invalidAction = invalidAction;
        this.year = year;
        this.ifCanExam = ifCanExam;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIfCanExam() {
        return ifCanExam;
    }

    public void setIfCanExam(int ifBaokao) {
        this.ifCanExam = ifBaokao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvalidAction() {
        return invalidAction;
    }

    public void setInvalidAction(String invalidAction) {
        this.invalidAction = invalidAction;
    }
}
