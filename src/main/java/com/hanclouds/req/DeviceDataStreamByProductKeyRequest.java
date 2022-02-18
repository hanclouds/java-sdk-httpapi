package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyDataStreamPageRequest;
import com.hanclouds.http.AbstractProductKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceDataStreamByProductKeyResponse;
import com.hanclouds.resp.DeviceDataStreamLatestDataResponse;
import com.hanclouds.util.StringUtils;

/**
 * 根据数据流名称获取设备最近数据点
 *
 * @author czl
 * @version 1.0
 * @date 2018/4/24 13:46
 */
public class DeviceDataStreamByProductKeyRequest extends AbstractProductKeyPageRequest<DeviceDataStreamByProductKeyResponse> {

    private Integer limit;
    private String order;
    private Long startTime;
    private Long endTime;
    private String dataName;
    private String timeUnit;



    public DeviceDataStreamByProductKeyRequest() {
        super("/devices/{productKey}/deviceData");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
        this.putQueryParameter("limit", limit.toString());
    }

    public Long getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Long startTime)
    {
        this.startTime = startTime;
        if(startTime != null){
            this.putQueryParameter("startTime", startTime.toString());
        }
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
        if(endTime != null){
            this.putQueryParameter("endTime",endTime.toString());
        }
    }


    public String getDataName() {
        return dataName;
    }


    public void setDataName(String dataName) {
        this.dataName = dataName;
        if (dataName != null) {
            this.putQueryParameter("dataName",dataName);
        }
    }

    @Override
    public String getOrder() {
        return order;
    }

    @Override
    public void setOrder(String order) {
        this.order = order;
        this.putQueryParameter("order", order);
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
        if (timeUnit != null){
            this.putQueryParameter("timeUnit",timeUnit);
        }
    }

    @Override
    public Class<DeviceDataStreamByProductKeyResponse> getResponseClass() {
        return DeviceDataStreamByProductKeyResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (!StringUtils.isEmpty(this.order)
                && !"asc".toLowerCase().equals(this.order.toLowerCase())
                && !"desc".toLowerCase().equals(this.order.toLowerCase())) {
            throw new HanCloudsClientException("order must be asc or desc");
        }

        if (!StringUtils.isEmpty(this.timeUnit)
                && !"ms".toLowerCase().equals(this.timeUnit.toLowerCase())
                && !"ns".toLowerCase().equals(this.timeUnit.toLowerCase())) {
            throw new HanCloudsClientException("timeUnit must be ms or ns");
        }

        if (this.limit <= 0) {
            throw new HanCloudsClientException("limit must greater than zero");
        }


    }
}
