package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceCreateDTO;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:11
 */
public class DeviceCreateResponse extends AbstractHttpResponse {

    private DeviceCreateDTO response;

    public DeviceCreateDTO getResponse() {
        return response;
    }

    public void setResponse(DeviceCreateDTO response) {
        this.response = response;
    }


    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        response = JSON.parseObject(baseHttpResponse.getBodyContent(), DeviceCreateDTO.class);
    }

}
