package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractProductKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceDataStreamDataByProductKeyPageResponse;
import com.hanclouds.util.StringUtils;
import com.hanclouds.util.ValidateUtils;

/**
 * 根据数据流名称获取设备数据流请求
 * @author czl
 * @version 1.0
 * @date 2018/4/24 13:46
 */
public class DeviceDataStreamDataByProductKeyPageRequest extends AbstractProductKeyPageRequest<DeviceDataStreamDataByProductKeyPageResponse> {

    private Long startTime;

    private Long endTime;

    private String dataName;

    public DeviceDataStreamDataByProductKeyPageRequest() {
        super("/devices/{productKey}/deviceData");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
        this.putQueryParameter("dataName",dataName);
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
    public Class<DeviceDataStreamDataByProductKeyPageResponse> getResponseClass() {
        return DeviceDataStreamDataByProductKeyPageResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        ValidateUtils.validatePage(this.page, this.pageSize);

        if (!StringUtils.isEmpty(this.order)
                && !"asc".toLowerCase().equals(this.order.toLowerCase())
                && !"desc".toLowerCase().equals(this.order.toLowerCase())) {
            throw new HanCloudsClientException("order must be asc or desc");
        }
    }
}
