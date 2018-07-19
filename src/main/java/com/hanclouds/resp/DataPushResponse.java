package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DataPushDTO;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/28 23:10
 */
public class DataPushResponse extends AbstractHttpResponse {

    private DataPushDTO response;

    public DataPushDTO getResponse() {
        return response;
    }

    public void setResponse(DataPushDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        response = JSON.parseObject(baseHttpResponse.getBodyContent(), DataPushDTO.class);
    }

}
