package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceArchiveRecordResponse;

/**
 * @author lih
 * @version 1.0
 * @date 2018/5/23 14:49
 */
@Deprecated
public class DeviceArchiveRecordRequest extends AbstractDeviceKeyRequest<DeviceArchiveRecordResponse> {

    private String deviceKey;


    public DeviceArchiveRecordRequest() {
        super("/devices/{deviceKey}/archiveRecord");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceArchiveRecordResponse> getResponseClass() {
        return DeviceArchiveRecordResponse.class;
    }

}
