package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 设备在线状态请求
 * @author czl
 * @version 1.0
 * @date 2018/4/8 16:20
 */
public class DeviceOnlineRequest extends AbstractDeviceKeyRequest<BooleanResponse> {

    public DeviceOnlineRequest() {
        super("/devices/{deviceKey}/isOnline");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
