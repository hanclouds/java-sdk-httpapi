package com.hanclouds.model;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/24 13:44
 */
public class DeviceDataDTO {

    private String userKey;

    private String productKey;

    private String deviceKey;

    private Long time;

    private String stream;

    private Integer type;

    private Object data;

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
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DeviceDataDTO{" +
                "userKey='" + userKey + '\'' +
                ", productKey='" + productKey + '\'' +
                ", deviceKey='" + deviceKey + '\'' +
                ", time=" + time +
                ", stream='" + stream + '\'' +
                ", type=" + type +
                ", data=" + data +
                '}';
    }
}
