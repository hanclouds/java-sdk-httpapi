package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceCommandDTO;

import java.util.List;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 11:44
 */
public class DeviceCommandListResponse extends AbstractHttpResponse {

    private List<DeviceCommandDTO> response;

    public List<DeviceCommandDTO> getResponse() {
        return response;
    }

    public void setResponse(List<DeviceCommandDTO> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseArray(new String(baseHttpResponse.getBodyContent()), DeviceCommandDTO.class);
    }

}
