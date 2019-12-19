package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ArchiveDTO;

/**
 * 档案信息响应
 * @author majiwei
 * @date 2019/10/24
 */
public class ArchiveResponse extends AbstractHttpResponse {
    private ArchiveDTO response;

    public ArchiveDTO getResponse() {
        return response;
    }

    public void setResponse(ArchiveDTO response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseObject(baseHttpResponse.getBodyContent(), ArchiveDTO.class);
    }
}
