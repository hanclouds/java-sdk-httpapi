package com.hanclouds.resp;

import com.alibaba.fastjson.JSON;
import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.model.ProductCmdModelDTO;

import java.util.List;

/**
 * @author czl
 * @version 1.0
 * @date 2018/4/30 13:14
 */
public class ProductCmdModelsResponse extends AbstractHttpResponse {
    private List<ProductCmdModelDTO> response;

    public List<ProductCmdModelDTO> getResponse() {
        return response;
    }

    public void setResponse(List<ProductCmdModelDTO> response) {
        this.response = response;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        this.response = JSON.parseArray(new String(baseHttpResponse.getBodyContent()), ProductCmdModelDTO.class);
    }
}
