package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.StringUtils;

/**
 * 设备启用
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:34
 */
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
