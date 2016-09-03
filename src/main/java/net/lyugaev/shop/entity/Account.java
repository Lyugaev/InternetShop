package net.lyugaev.shop.entity;

/**
 * Created by dmitry on 29.08.16.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    @Size(min=1)
    @NotNull
    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    private String userName;

    @Size(min=1)
    @NotNull
    @Column(name = "Password", length = 20, nullable = false)
    private String password;

    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;

    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;

    public Account() {
        this.userRole = ROLE_USER;
        this.active = true;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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