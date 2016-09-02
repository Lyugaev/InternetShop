package net.lyugaev.shop.entity;

/**
 * Created by dmitry on 29.08.16.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    private String userName;
    private String password;
    private boolean active;
    private String userRole;

    public Account() {
        this.userRole = ROLE_USER;
        this.active = true;
    }

    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "Password", length = 20, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "Active", length = 1, nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name = "User_Role", length = 20, nullable = false)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        if (userRole == null)
            userRole = ROLE_USER;

        this.userRole = userRole;
    }

    @Override
    public String toString()  {
        return "["+ this.userName+","+ this.password+","+ this.userRole+"]";
    }

}