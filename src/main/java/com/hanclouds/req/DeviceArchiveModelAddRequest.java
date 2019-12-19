package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.DeviceArchiveFieldDTO;
import com.hanclouds.resp.DeviceArchiveModelResponse;
import com.hanclouds.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:14
 */
@Deprecated
public class DeviceArchiveModelAddRequest extends AbstractProductKeyRequest<DeviceArchiveModelResponse> {

    private String modelName;


    Map<String, DeviceArchiveFieldDTO> propertyData;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
        this.putQueryParameter("modelName", modelName);
    }

    public Map<String, DeviceArchiveFieldDTO> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, DeviceArchiveFieldDTO> propertyData) {
        this.propertyData = propertyData;
    }

    public DeviceArchiveModelAddRequest() {
        super("/products/{productKey}/archiveModels");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<DeviceArchiveModelResponse> getResponseClass() {
        return DeviceArchiveModelResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (StringUtils.isBlank(modelName)) {
            throw new HanCloudsClientException("modelName can not null or empty");
        }
        if (propertyData == null || propertyData.size() <= 0) {
            throw new HanCloudsClientException("propertyData can not null or empty");
        }
        Map<String, Object> req = new HashMap<String, Object>(3);
        req.put("productKey", this.productKey);
        req.put("modelName", this.modelName);
        req.put("propertyData", propertyData);
        this.setBodyContentByObject(req);
    }
}
