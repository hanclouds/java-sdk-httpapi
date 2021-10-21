package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceInfoResponse;

/**
 * 根据DeviceKey查询设备信息
 * @author majiwei
 * @date 2019/12/10
 */
public class DeviceInfoByDeviceKeyRequest extends AbstractDeviceKeyRequest<DeviceInfoResponse>
{
    public DeviceInfoByDeviceKeyRequest() {
        super("/devices/{deviceKey}");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceInfoResponse> getResponseClass() {
        return DeviceInfoResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
    }
}
