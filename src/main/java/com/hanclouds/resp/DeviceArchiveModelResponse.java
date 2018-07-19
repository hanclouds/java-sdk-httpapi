package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceArchiveModelDTO;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:17
 */
public class DeviceArchiveModelResponse extends AbstractHttpResponse {

    private DeviceArchiveModelDTO response;

    public DeviceArchiveModelDTO getResponse() {
        return response;
    }

    public void setResponse(DeviceArchiveModelDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        response = JSON.parseObject(baseHttpResponse.getBodyContent(), DeviceArchiveModelDTO.class);
    }
}
