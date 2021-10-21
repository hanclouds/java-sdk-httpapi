package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceEventPageResponse;

/**
 * 设备事件查询
 * @author czl
 * @version 1.0
 * @date 2018/4/30 13:03
 */
public class DeviceEventPageRequest extends AbstractDeviceKeyPageRequest<DeviceEventPageResponse> {

    private Long startTime;

    private Long endTime;

    public DeviceEventPageRequest() {
        super("/devices/{deviceKey}/events");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {

        this.startTime = startTime;
        this.putQueryParameter("startTime", startTime.toString());
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {

        this.endTime = endTime;
        this.putQueryParameter("endTime", endTime.toString());
    }



    @Override
    public Class<DeviceEventPageResponse> getResponseClass() {
        return DeviceEventPageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (this.page <= 0) {
            throw new HanCloudsClientException("page must greater than zero");
        }

        if (this.pageSize <= 0) {
            throw new HanCloudsClientException("pageSize must greater than zero");
        }
    }

}
