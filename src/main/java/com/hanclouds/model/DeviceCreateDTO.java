package com.hanclouds.model;

/**
 * @author czl
 * @version 1.0
 * @date 2018/5/31 0:42
 */
public class DeviceCreateDTO {

    /**
     * deviceKey
     */
    private String deviceKey;
    /**
     * 设备级uploadToken，初次创建时返回
     */
    private String uploadToken;
    /**
     * 设备级queryToken，初次创建时返回
     */
    private String queryToken;
    /**
     * 设备级cmdToken，除吃创建时返回
     */
    private String cmdToken;
    /**
     * 设备级对称加密秘钥
     */
    private String deviceSecret;

    public String getDeviceKey() { return deviceKey; }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public String getUploadToken() {
        return uploadToken;
    }

    public void setUploadToken(String uploadToken) {
        this.uploadToken = uploadToken;
    }

    public String getQueryToken() {
        return queryToken;
    }

    public void setQueryToken(String queryToken) {
        this.queryToken = queryToken;
    }

    public String getCmdToken() {
        return cmdToken;
    }

    public void setCmdToken(String cmdToken) {
        this.cmdToken = cmdToken;
    }

    public String getDeviceSecret() {
        return deviceSecret;
    }

    public void setDeviceSecret(String deviceSecret) {
        this.deviceSecret = deviceSecret;
    }

    @Override
    public String toString() {
        return "DeviceCreateDTO{" +
                "deviceKey='" + deviceKey + '\'' +
                ", uploadToken='" + uploadToken + '\'' +
                ", queryToken='" + queryToken + '\'' +
                ", cmdToken='" + cmdToken + '\'' +
                ", deviceSecret='" + deviceSecret + '\'' +
                '}';
    }
}
