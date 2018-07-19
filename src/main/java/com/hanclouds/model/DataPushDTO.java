package com.hanclouds.model;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/28 23:08
 */
public class DataPushDTO {
    private String userName;
    private String password;
    private String secret;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "DataPushDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
