package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyDataStreamPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceDataStreamLatestDataResponse;
import com.hanclouds.util.StringUtils;

/**
 * 根据数据流名称获取设备最近数据点
 *
 * @author czl
 * @version 1.0
 * @date 2018/4/24 13:46
 */
public class DeviceDataStreamLatestDataRequest extends AbstractDeviceKeyDataStreamPageRequest<DeviceDataStreamLatestDataResponse> {

    private Integer limit = 100;

    private String order;


    public DeviceDataStreamLatestDataRequest() {
        super("/devices/{deviceKey}/datastreams/{dataName}/latestData");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
        this.putQueryParameter("limit", limit.toString());
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

    @Override
    public Class<DeviceDataStreamLatestDataResponse> getResponseClass() {
        return DeviceDataStreamLatestDataResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (this.limit <= 0) {
            throw new HanCloudsClientException("limit must greater than zero");
        }
    }
}
