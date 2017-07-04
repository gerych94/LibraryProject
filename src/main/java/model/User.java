package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Vitaliy on 10.06.2017.
 */
@ManagedBean(name = "user")
@SessionScoped
public class User implements Serializable {

    private String userName;
    private String password;

    public User(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
