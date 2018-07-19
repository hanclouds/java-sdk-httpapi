package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.StringUtils;

/**
 * 重置鉴权ack标志位（通过key）
 * @author czl
 * @version 1.0
 * @date 2018/4/30 13:26
 */
public class DeviceCreateAckResetRequest extends AbstractDeviceKeyRequest<BooleanResponse> {

    public DeviceCreateAckResetRequest() {
        super("/devices/{deviceKey}/createAck");
        this.setHttpMethod(HttpMethodEnum.DELETE);
    }


    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}