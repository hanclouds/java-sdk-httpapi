package com.hanclouds.req;

import com.hanclouds.http.AbstractDeviceKeyRequest;
import com.hanclouds.http.HttpMethodEnum;
import com.hanclouds.resp.BooleanResponse;

/**
 * @author huyunsen
 * @date 2022/5/19 16:27
 */
public class VideoRecordControlRequest extends AbstractDeviceKeyRequest<BooleanResponse> {
    private String sipId;

    private String channelId;

    private String command;

    public VideoRecordControlRequest() {
        super("/videos/{deviceKey}/recordControl");
        this.setHttpMethod(HttpMethodEnum.POST);
    }

    public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
        this.putQueryParameter("sipId",sipId);
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
        this.putQueryParameter("channelId",channelId);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        this.putQueryParameter("command",command);
    }

    @Override
    public Class<BooleanResponse> getResponseClass() {
        return BooleanResponse.class;
    }
}
