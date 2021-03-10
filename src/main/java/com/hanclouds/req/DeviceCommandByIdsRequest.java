package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceCommandListResponse;
import com.hanclouds.util.StringUtils;

import java.util.List;

/**
 * 通过命令id list获取命令信息
 * @author czl
 * @version 1.0
 * @date 2018/4/30 12:04
 */
public class DeviceCommandByIdsRequest extends AbstractDeviceKeyRequest<DeviceCommandListResponse> {

    private List<String> commandIds;

    public DeviceCommandByIdsRequest() {
        super("/devices/{deviceKey}/commandsFilters/byCommandIds");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    public List<String> getCommandIds() {
        return commandIds;
    }

    public void setCommandIds(List<String> commandIds) {
        this.commandIds = commandIds;
    }

    @Override
    public Class<DeviceCommandListResponse> getResponseClass() {
        return DeviceCommandListResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {

        super.validate();

        if (this.commandIds ==null|| this.commandIds.size()<= 0) {
            throw new HanCloudsClientException("page must greater than zero");
        }
        setBodyContentByObject(this.commandIds);
    }
}
