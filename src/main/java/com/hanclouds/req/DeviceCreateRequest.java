package com.hanclouds.req;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceCreateResponse;
import com.hanclouds.util.SdkRegexUtils;
import com.hanclouds.util.StringUtils;

/**
 * 创建设备
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:12
 */
public class DeviceCreateRequest extends AbstractProductKeyRequest<DeviceCreateResponse> {
    /**
     * 设备序列号
     */
    private String sn;
    /**
     * 设备描述
     */
    private String descr;

    private String deviceType;

    private String deviceName;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDeviceName() { return deviceName; }

    public void setDeviceName(String deviceName) { this.deviceName = deviceName;}

    public DeviceCreateRequest() {
        super("/products/{productKey}/devices");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public Class<DeviceCreateResponse> getResponseClass() {
        return DeviceCreateResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (StringUtils.isBlank(deviceName)) {
            throw new HanCloudsClientException("device name can not null or empty");
        }
        if (!SdkRegexUtils.checkDeviceName(deviceName)) {
            throw new HanCloudsClientException("device name format error");
        }
        if (StringUtils.isBlank(sn)) {
            throw new HanCloudsClientException("sn can not null or empty");
        }
        if (StringUtils.isBlank(deviceType)) {
            throw new HanCloudsClientException("deviceType can not null or empty");
        }
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(
                DeviceCreateRequest.class,
                "sn","descr","deviceType","deviceName"
        );
        setBodyContentByObject(filter);
    }
}
