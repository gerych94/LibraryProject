package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Vitaliy on 10.06.2017.
 */
@ManagedBean
@SessionScoped
public class User {

    private String userName;

    public User(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
