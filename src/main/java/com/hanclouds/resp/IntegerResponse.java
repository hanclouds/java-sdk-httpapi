package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/4 10:26
 */
public class IntegerResponse extends AbstractHttpResponse {

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        value = Integer.valueOf(new String(baseHttpResponse.getBodyContent()));
    }
}
