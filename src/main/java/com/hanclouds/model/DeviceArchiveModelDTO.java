package com.hanclouds.model;

import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:00
 */
public class DeviceArchiveModelDTO {
    /**
     * 产品productKey
     */
    private String productKey;

    /**
     * 模板id
     */
    private Integer modelId;

    /**
     * 模板名
     */
    private String modelName;

    /**
     * 模板属性
     */
    Map<String, DeviceArchiveFieldDTO> propertyData;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Map<String, DeviceArchiveFieldDTO> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, DeviceArchiveFieldDTO> propertyData) {
        this.propertyData = propertyData;
    }

    @Override
    public String toString() {
        return "DeviceArchiveModelDTO{" +
                "productKey='" + productKey + '\'' +
                ", modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", propertyData=" + propertyData +
                '}';
    }
}
