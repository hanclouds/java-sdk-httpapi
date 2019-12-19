package com.hanclouds.req;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;
import com.hanclouds.util.SdkRegexUtils;
import com.hanclouds.util.StringUtils;

/**
 * 修改设备信息
 * @author majiwei
 * @date 2019/11/12
 */
public class DeviceUpdateRequest extends AbstractDeviceKeyRequest<BooleanResponse> {

    /** 设备名称 */
    private String deviceName;

    /** 描述 */
    private String desc;

    public DeviceUpdateRequest() {
        super("/devices/{deviceKey}");
        this.setHttpMethod(HttpMethodEnum.PUT);
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (StringUtils.isNotBlank(deviceName) && !SdkRegexUtils.checkDeviceName(deviceName)) {
            throw new HanCloudsClientException("device name format error");
        }

        if(StringUtils.isBlank(deviceName) && StringUtils.isBlank(desc)){
            throw new HanCloudsClientException("device name and desc cannot both be empty");
        }

        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
                DeviceUpdateRequest.class,"deviceName","desc");
        setBodyContentByObject(filter);
    }
}
