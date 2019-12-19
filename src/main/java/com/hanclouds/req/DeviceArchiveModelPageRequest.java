package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceArchiveModelPageResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:38
 */
@Deprecated
public class DeviceArchiveModelPageRequest extends AbstractProductKeyPageRequest<DeviceArchiveModelPageResponse> {

    private String modelName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
        this.putQueryParameter("modelName", this.modelName);
    }

    public DeviceArchiveModelPageRequest() {
        super("/products/{productKey}/archiveModels");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceArchiveModelPageResponse> getResponseClass() {
        return DeviceArchiveModelPageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
    }
}
