package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceArchiveRecordDTO;

/**
 * @author czl
 * @version 1.0
 * @date 2018/6/25 15:56
 */
public class DeviceArchiveRecordResponse extends AbstractHttpResponse {

    private DeviceArchiveRecordDTO response;

    public DeviceArchiveRecordDTO getResponse() {
        return response;
    }

    public void setResponse(DeviceArchiveRecordDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }


        response = JSON.parseObject(baseHttpResponse.getBodyContent(), DeviceArchiveRecordDTO.class);
    }
}