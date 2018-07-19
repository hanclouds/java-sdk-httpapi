package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.LongResponse;
import com.hanclouds.util.StringUtils;

/**
 * @author lih
 * @version 1.0
 * @date 2018/6/19 17:56
 */
public class DeviceLastConnectTimeRequest extends AbstractDeviceKeyRequest<LongResponse> {

    public DeviceLastConnectTimeRequest() {
        super("/devices/{deviceKey}/lastConnectTime");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<LongResponse> getResponseClass() {
        return LongResponse.class;
    }
}
