package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.VideoStreamDTO;

/**
 * @author xxx
 * @date 2021/11/12 17:35
 */
public class VideoStreamResponse extends AbstractHttpResponse {
    private VideoStreamDTO response;

    public VideoStreamDTO getResponse() {
        return response;
    }

    public void setResponse(VideoStreamDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }
        response = JSON.parseObject(baseHttpResponse.getBodyContent(),VideoStreamDTO.class);
    }
}
