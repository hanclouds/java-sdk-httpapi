package com.hanclouds.req;

import com.hanclouds.exception.HanCloudsClientException;
import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.AbstractHttpRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.DeviceCommandResponse;
import com.hanclouds.util.StringUtils;

/**
 * 获取单个命令详情
 * @author czl
 * @version 1.0
 * @date 2018/4/30 11:54
 */
public class DeviceCommandRequest extends AbstractDeviceKeyRequest<DeviceCommandResponse> {

    private String commandId = null;

    public DeviceCommandRequest() {
        super("/devices/{deviceKey}/commands/{commandId}");
        this.setHttpMethod(HttpMethodEnum.GET);
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    @Override
    public Class<DeviceCommandResponse> getResponseClass() {
        return DeviceCommandResponse.class;
    }

    @Override
    public void validate() throws HanCloudsClientException {
        super.validate();
        if (StringUtils.isBlank(commandId)) {
            throw new HanCloudsClientException("commandId can not null or empty");
        }
        this.setUrl(this.getUrl().replace("{commandId}", this.commandId));
    }
}
