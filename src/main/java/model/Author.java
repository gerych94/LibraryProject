package model;

import java.io.Serializable;


/**
 * Created by Vitaliy on 25.05.2017.
 */
public class Author implements Serializable{

    private  int id;
    private String fio;
    private String birthday;

    public Author(){
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
