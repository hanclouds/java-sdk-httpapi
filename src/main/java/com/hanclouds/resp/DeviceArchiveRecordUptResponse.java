package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/28 20:53
 */
public class DeviceArchiveRecordUptResponse extends AbstractHttpResponse {

    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }

        value =Boolean.valueOf(new String(baseHttpResponse.getBodyContent()));
    }
}
