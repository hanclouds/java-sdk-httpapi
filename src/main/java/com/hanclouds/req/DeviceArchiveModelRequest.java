package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceArchiveModelResponse;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
@Deprecated
public class DeviceArchiveModelRequest extends AbstractProductKeyRequest<DeviceArchiveModelResponse> {

    private Integer archiveModelId;

    public DeviceArchiveModelRequest() {
        super("/products/{productKey}/archiveModels/{archiveModelId}");
        this.setHttpMethod(HttpMethodEnum.GET);
    }


    public Integer getArchiveModelId() {
        return archiveModelId;
    }

    public void setArchiveModelId(Integer archiveModelId) {
        this.archiveModelId = archiveModelId;
    }


    @Override
    public Class<DeviceArchiveModelResponse> getResponseClass() {
        return DeviceArchiveModelResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (this.archiveModelId == null || this.archiveModelId <= 0) {
            throw new HanCloudsClientException("archive model id can't be null or zero");
        }

        this.setUrl(this.getUrl().replace("{archiveModelId}", this.archiveModelId.toString()));
    }
}
