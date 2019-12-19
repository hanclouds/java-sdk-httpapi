package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;
import com.hanclouds.util.StringUtils;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/5 11:39
 */
public class LongResponse extends AbstractHttpResponse {
    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        String result = new String(baseHttpResponse.getBodyContent());
        value = StringUtils.isEmpty(result) ? 0L : Long.valueOf(result);
    }
}
