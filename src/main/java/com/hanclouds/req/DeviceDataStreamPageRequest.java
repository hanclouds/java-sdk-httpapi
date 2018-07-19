package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DataStreamPageResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/8 15:06
 */
public class DeviceDataStreamPageRequest extends AbstractDeviceKeyRequest<DataStreamPageResponse> {

    public DeviceDataStreamPageRequest() {
        super("/devices/{deviceKey}/datastreams");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DataStreamPageResponse> getResponseClass() {
        return DataStreamPageResponse.class;
    }
}
