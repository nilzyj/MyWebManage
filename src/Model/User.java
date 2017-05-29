package Model;

/**
 * Created by dim on 2017/4/29.
 */
public class User {
    private int ID;
    private String name;
    private String password;

    public User (String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User (int ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
