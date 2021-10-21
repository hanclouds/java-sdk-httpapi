package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.LongResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/5 11:30
 */
public class DeviceDataTotalNumRequest extends AbstractDeviceKeyRequest<LongResponse> {

    public DeviceDataTotalNumRequest() {
        super("/devices/{deviceKey}/dataTotalNum");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<LongResponse> getResponseClass() {
        return LongResponse.class;
    }
}
