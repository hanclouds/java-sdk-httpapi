package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DeviceDataDTO;

import java.util.List;

/**
 * 根据多个数据流名称最新数据点返回
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class DeviceDataStreamLatestDataResponse extends AbstractHttpResponse {

    private List<DeviceDataDTO> response;

    public List<DeviceDataDTO> getResponse() {
        return response;
    }

    public void setResponse(List<DeviceDataDTO> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseArray(new String(baseHttpResponse.getBodyContent()), DeviceDataDTO.class);
    }
}
