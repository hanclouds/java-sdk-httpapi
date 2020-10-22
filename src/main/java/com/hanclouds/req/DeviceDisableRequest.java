package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 设备禁用
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:33
 */
public class DeviceDisableRequest extends AbstractDeviceKeyRequest<BooleanResponse> {
    public DeviceDisableRequest() {
        super("/devices/{deviceKey}/disable");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
