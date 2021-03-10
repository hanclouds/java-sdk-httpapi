package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceCommandDTO;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 11:54
 */
public class DeviceCommandResponse extends AbstractHttpResponse {
    private DeviceCommandDTO response;

    public DeviceCommandDTO getResponse() {
        return response;
    }

    public void setResponse(DeviceCommandDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseObject(baseHttpResponse.getBodyContent(), DeviceCommandDTO.class);
    }
}
