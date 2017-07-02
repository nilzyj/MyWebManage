package Model;

/**
 * Created by dim on 2017/5/18.
 */
public class InvalidAction {
    private int ID;
    private String username;
    private String name;
    private String invalidAction;
    private int year;
    private String time;
    private String person;
    private int ifCanExam;

    public InvalidAction(int ID, String username, String name, String invalidAction, int year, String time, String person, int ifCanExam) {
        this.ID = ID;
        this.username = username;
        this.name = name;
        this.invalidAction = invalidAction;
        this.year = year;
        this.time = time;
        this.person = person;
        this.ifCanExam = ifCanExam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
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
