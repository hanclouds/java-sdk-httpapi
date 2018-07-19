package com.hanclouds.model;

import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:01
 */
public class DeviceArchiveRecordDTO {

    private Integer recordId;

    private Integer modelId;

    private String deviceKey;

    Map<String,String> propertyData;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

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
        return "DeviceArchiveRecordDTO{" +
                "recordId=" + recordId +
                ", modelId=" + modelId +
                ", deviceKey='" + deviceKey + '\'' +
                ", propertyData=" + propertyData +
                '}';
    }
}
