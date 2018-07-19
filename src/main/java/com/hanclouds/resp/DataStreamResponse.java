package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.DataStreamDTO;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/30 15:22
 */
public class DataStreamResponse extends AbstractHttpResponse {
    private DataStreamDTO response;

    public DataStreamDTO getResponse() {
        return response;
    }

    public void setResponse(DataStreamDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }


        response = JSON.parseObject(baseHttpResponse.getBodyContent(), DataStreamDTO.class);
    }
}
