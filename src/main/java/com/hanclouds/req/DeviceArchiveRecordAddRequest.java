package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceArchiveRecordAddResponse;
import com.hanclouds.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:49
 */
@Deprecated
public class DeviceArchiveRecordAddRequest extends AbstractDeviceKeyRequest<DeviceArchiveRecordAddResponse> {

    private Integer modelId;

    private String deviceKey;

    private Map<String, String> propertyData;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Map<String, String> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, String> propertyData) {
        this.propertyData = propertyData;
    }

    public DeviceArchiveRecordAddRequest() {
        super("/devices/{deviceKey}/archiveRecord");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<DeviceArchiveRecordAddResponse> getResponseClass() {
        return DeviceArchiveRecordAddResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (modelId == null || modelId < 0) {
            throw new HanCloudsClientException("modelId can not null or empty");
        }
        if (propertyData == null || propertyData.size() <= 0) {
            throw new HanCloudsClientException("propertyData can not null or empty");
        }
        Map<String, Object> req = new HashMap<String, Object>(3);
        req.put("modelId", this.modelId);
        req.put("propertyData", propertyData);
        this.setBodyContentByObject(req);
    }
}
