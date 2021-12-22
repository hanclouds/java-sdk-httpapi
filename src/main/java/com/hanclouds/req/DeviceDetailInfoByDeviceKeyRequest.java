package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceDetailInfoResponse;

/**
 * 根据DeviceKey查询设备信息
 * @author majiwei
 * @date 2019/12/10
 */
public class DeviceDetailInfoByDeviceKeyRequest extends AbstractDeviceKeyRequest<DeviceDetailInfoResponse>
{
    public DeviceDetailInfoByDeviceKeyRequest() {
        super("/devices/detail/{deviceKey}");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    @Override
    public Class<DeviceDetailInfoResponse> getResponseClass() {
        return DeviceDetailInfoResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
    }
}
