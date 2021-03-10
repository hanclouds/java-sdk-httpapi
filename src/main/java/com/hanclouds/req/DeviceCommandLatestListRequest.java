package com.hanclouds.req;


import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceCommandListResponse;
import com.hanclouds.util.StringUtils;

/**
 * 获取设备的最近命令信息
 * @author czl
 * @version 1.0
 * @date 2018/4/30 11:37
 */
public class DeviceCommandLatestListRequest extends AbstractDeviceKeyRequest<DeviceCommandListResponse> {

    private Integer limit=100;

    public DeviceCommandLatestListRequest() {
        super("/devices/{deviceKey}/latestCommands");
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
    public Class<DeviceCommandListResponse> getResponseClass() {
        return DeviceCommandListResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {

        super.validate();

        if (this.limit <= 0) {
            throw new HanCloudsClientException("limit must greater than zero");
        }
    }
}
