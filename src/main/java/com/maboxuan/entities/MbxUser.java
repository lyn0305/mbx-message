package com.maboxuan.entities;

import lombok.Data;

import java.io.Serializable;


public class MbxUser implements Serializable {
    private Integer id;

    private String userName;

    private String password;

    private Integer userExtraId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserExtraId() {
        return userExtraId;
    }

    public void setUserExtraId(Integer userExtraId) {
        this.userExtraId = userExtraId;
    }
}