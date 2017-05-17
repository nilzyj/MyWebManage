package Model;

import com.google.gson.JsonObject;

/**
 * Created by dim on 2017/5/16.
 */
public class Student {
    private int ID;
    private String name;
    private JsonObject jsonInfo;
    private int year;
    private String baokaodian;
    private String baokaohao;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBaokaodian() {
        return baokaodian;
    }

    public void setBaokaodian(String baokaodian) {
        this.baokaodian = baokaodian;
    }

    public String getBaokaohao() {
        return baokaohao;
    }

    public void setBaokaohao(String baokaohao) {
        this.baokaohao = baokaohao;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonObject getJsonInfo() {
        return jsonInfo;
    }

    public void setJsonInfo(JsonObject jsonInfo) {
        this.jsonInfo = jsonInfo;
    }
}
