package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.DeviceArchiveFieldDTO;
import com.hanclouds.resp.BooleanResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/29 15:05
 */
@Deprecated
public class DeviceArchiveModelUptRequest extends AbstractProductKeyRequest<BooleanResponse> {

    private String modelName;

    private String desc;

    private Integer archiveModelId;

    private Map<String, DeviceArchiveFieldDTO> propertyData;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getArchiveModelId() {
        return archiveModelId;
    }

    public void setArchiveModelId(Integer archiveModelId) {
        this.archiveModelId = archiveModelId;
    }

    public Map<String, DeviceArchiveFieldDTO> getPropertyData() {
        return propertyData;
    }

    public void setPropertyData(Map<String, DeviceArchiveFieldDTO> propertyData) {
        this.propertyData = propertyData;
    }

    public DeviceArchiveModelUptRequest() {
        super("/products/{productKey}/archiveModels/{archiveModelId}");
        this.setHttpMethod(HttpMethodEnum.PUT);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (archiveModelId == null || archiveModelId < 0) {
            throw new HanCloudsClientException("archiveModelId can not null or empty");
        }
        if (propertyData == null || propertyData.size() <= 0) {
            throw new HanCloudsClientException("propertyData can not null or empty");
        }

        this.setUrl(this.getUrl().replace("{archiveModelId}", this.archiveModelId.toString()));

        Map<String, Object> req = new HashMap<String, Object>(3);
        req.put("propertyData", this.propertyData);
        req.put("modelName", this.modelName);
        req.put("desc", this.desc);
        this.setBodyContentByObject(req);
    }
}
