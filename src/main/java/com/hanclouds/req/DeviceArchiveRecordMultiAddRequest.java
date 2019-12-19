package com.hanclouds.req;

import com.alibaba.fastjson.JSONObject;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.model.DeviceArchiveRecordMultiAddDTO;
import com.hanclouds.resp.DeviceArchiveRecordMultiAddResponse;
import com.hanclouds.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 16:19
 */
@Deprecated
public class DeviceArchiveRecordMultiAddRequest extends AbstractHttpRequest<DeviceArchiveRecordMultiAddResponse> {

    private String productKey;

    private Integer modelId;

    private List<DeviceArchiveRecordMultiAddDTO> datas;

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

    public List<DeviceArchiveRecordMultiAddDTO> getDatas() {
        return datas;
    }

    public void setDatas(List<DeviceArchiveRecordMultiAddDTO> datas) {
        this.datas = datas;
    }

    public DeviceArchiveRecordMultiAddRequest() {
        super("/products/{productKey}/addMultiDeviceArchiveRecords");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<DeviceArchiveRecordMultiAddResponse> getResponseClass() {
        return DeviceArchiveRecordMultiAddResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        if (StringUtils.isBlank(productKey)) {
            throw new HanCloudsClientException("productKey can not null or empty");
        }
        if (modelId == null || modelId < 0) {
            throw new HanCloudsClientException("modelId can not null or empty");
        }
        if (datas == null || datas.size() <= 0) {
            throw new HanCloudsClientException("datas can not null or empty");
        }
        Map<String, Object> req = new HashMap<String, Object>(2);
        req.put("modelId", this.modelId);
        req.put("datas", this.datas);
        this.setBodyContentByObject(req);
        this.setUrl(
                this.getUrl().replace("{productKey}", productKey));
    }
}
