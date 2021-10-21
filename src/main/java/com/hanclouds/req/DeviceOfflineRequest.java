package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 强制设备下线
 * @author czl
 * @version 1.0
 * @date 2018/4/30 13:27
 */
public class DeviceOfflineRequest extends AbstractDeviceKeyRequest<BooleanResponse> {

    public DeviceOfflineRequest() {
        super("/devices/{deviceKey}/offline");
        this.setHttpMethod(HttpMethodEnum.POST);
    }


    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
