package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceArchiveRecordMultiDTO;

import java.util.Map;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 16:17
 */
public class DeviceArchiveRecordMultiAddResponse extends AbstractHttpResponse {

    private Map<String, Integer> response;

    public Map<String, Integer> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Integer> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        response = JSON.parseObject(baseHttpResponse.getBodyContent(), Map.class);
    }
}
