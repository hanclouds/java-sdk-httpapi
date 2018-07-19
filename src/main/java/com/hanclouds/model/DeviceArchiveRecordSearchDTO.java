package com.hanclouds.model;

import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:02
 */
public class DeviceArchiveRecordSearchDTO {
    private Integer recordId;

    private Integer modelId;

    private String productKey;

    private String deviceKey;

    private Map<String, Object> propertyData;

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

    public Map<String, Object> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, Object> propertyData) {
        this.propertyData = propertyData;
    }

    @Override
    public String toString() {
        return "DeviceArchiveRecordSearchDTO{" +
                "recordId=" + recordId +
                ", modelId=" + modelId +
                ", productKey='" + productKey + '\'' +
                ", deviceKey='" + deviceKey + '\'' +
                ", propertyData=" + propertyData +
                '}';
    }
}
