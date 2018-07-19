package com.hanclouds.resp;

import com.hanclouds.http.AbstractHttpResponse;
import com.hanclouds.http.BaseHttpResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:47
 */
public class DeviceArchiveRecordAddResponse extends AbstractHttpResponse {

    private Integer recordId;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @Override
    public void parseBaseHttpResponse() {
        BaseHttpResponse baseHttpResponse = this.baseHttpResponse;
        if (baseHttpResponse == null || baseHttpResponse.getBodyContent() == null) {
            return;
        }
        recordId=Integer.parseInt(new String(baseHttpResponse.getBodyContent()));
    }
}
