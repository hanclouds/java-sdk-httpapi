package com.hanclouds.model;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:59
 */
public class DeviceEventDTO {
    private String userKey;
    private String productKey;
    private String deviceKey;
    private Long time;
    private Integer event;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getEvent() {
        return this.event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "DeviceEventDTO{" +
                "userKey='" + userKey + '\'' +
                ", productKey='" + productKey + '\'' +
                ", deviceKey='" + deviceKey + '\'' +
                ", time=" + time +
                ", event=" + event +
                '}';
    }
}
