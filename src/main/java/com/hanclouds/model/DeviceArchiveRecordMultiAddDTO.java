package com.hanclouds.model;

import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/24 16:44
 */
public class DeviceArchiveRecordMultiAddDTO {

    private String deviceKey;

    private Map<String, String> propertyData;

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey;
    }

    public Map<String, String> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, String> propertyData) {
        this.propertyData = propertyData;
    }

    @Override
    public String toString() {
        return "DeviceArchiveRecordMultiAddDTO{" +
                "deviceKey='" + deviceKey + '\'' +
                ", propertyData=" + propertyData +
                '}';
    }
}
