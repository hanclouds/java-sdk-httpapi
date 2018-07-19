package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyPageRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceEventListResponse;

/**
 * @author zhangzhan
 * @version 1.0
 * @date 2018/6/25 10:20
 */
public class DeviceEventLatestListRequest extends AbstractDeviceKeyPageRequest<DeviceEventListResponse> {
    private Integer limit=100;

    public DeviceEventLatestListRequest() {
        super("/devices/{deviceKey}/latestEvents");
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
    public Class<DeviceEventListResponse> getResponseClass() {
        return DeviceEventListResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();

        if (this.limit <= 0) {
            throw new HanCloudsClientException("limit must greater than zero");
        }
    }
}
