package com.hanclouds.model;

import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:02
 */
public class DeviceArchiveRecordMultiDTO {
    private Integer modelId;

    private Map<String, Integer> recordIdData;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Map<String, Integer> getRecordIdData() {
        return recordIdData;
    }

    public void setRecordIdData(Map<String, Integer> recordIdData) {
        this.recordIdData = recordIdData;
    }

    @Override
    public String toString() {
        return "DeviceArchiveRecordMultiDTO{" +
                "modelId=" + modelId +
                ", recordIdData=" + recordIdData +
                '}';
    }
}
