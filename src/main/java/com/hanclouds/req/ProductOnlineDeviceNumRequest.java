package com.hanclouds.req;

import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.IntegerResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/4 10:20
 */
public class ProductOnlineDeviceNumRequest extends AbstractProductKeyRequest<IntegerResponse> {

    public ProductOnlineDeviceNumRequest() {
        super("/products/{productKey}/onlineDeviceNum");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<IntegerResponse> getResponseClass() {
        return IntegerResponse.class;
    }
}
