package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;

/**
 * Boolean 类型返回值
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class BooleanResponse extends AbstractHttpResponse {

    private Boolean value;

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        value =Boolean.valueOf(new String(baseHttpResponse.getBodyContent()));
    }

    public Boolean getValue(){return value;}
}
