package model;

import java.io.Serializable;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class Genre implements Serializable {

    private int id;
    private String genreName;

    public Genre(){}


    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
