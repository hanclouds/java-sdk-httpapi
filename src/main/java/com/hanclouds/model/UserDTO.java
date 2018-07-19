package com.hanclouds.model;

import java.util.Date;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/27 16:45
 */
public class UserDTO {
    /**
     * userKey
     */
    private String userKey;
    /**
     * 1:普通开发者，2：企业用户
     */
    private Short type;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String tel;
    /**
     * 注册IP
     */
    private String regIp;
    /**
     * 注册来源，1:来自门户网站
     */
    private Short regFrom;
    /**
     * 注册方式：填写tel、email等字符串
     */
    private String regWay;
    /**
     * 扩展数据
     */
    private Object extendData;

    private Date createAt;
    private Date updateAt;
    private Date lastLoginTime;
    private String lastLoginIp;
    private String nickName;


    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public Short getRegFrom() {
        return regFrom;
    }

    public void setRegFrom(Short regFrom) {
        this.regFrom = regFrom;
    }

    public String getRegWay() {
        return regWay;
    }

    public void setRegWay(String regWay) {
        this.regWay = regWay;
    }

    public Object getExtendData() {
        return extendData;
    }

    public void setExtendData(Object extendData) {
        this.extendData = extendData;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userKey='" + userKey + '\'' +
                ", type=" + type +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", regIp='" + regIp + '\'' +
                ", regFrom=" + regFrom +
                ", regWay='" + regWay + '\'' +
                ", extendData=" + extendData +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
