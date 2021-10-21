package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * 设备启用
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:34
 */
@Deprecated
public class DeviceEnableRequest extends AbstractDeviceKeyRequest<BooleanResponse> {

    public DeviceEnableRequest() {
        super("/devices/{deviceKey}/enable");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
